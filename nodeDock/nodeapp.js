//express , easy way to setup node server
var express = require('express');
//mongodbclient used for connection.
var MongoClient = require('mongodb').MongoClient;
//assertions
var assert = require('assert');


// Application ports and paths
//###############################
var port = 8082;
var app = express();
app.get('/ping', function (req, res) {
  res.send('Amazing! you just pinged the node applications. Why dont you try the path "/nodeInsert" or "/nodeGet \n');
});

app.get('/nodeInsert', function (req, res) {
    MongoClient.connect(mongoDbUrl, function (err, db) {
      if(err){
        res.send('<h1>Seriously?? Connecting to non existing MongoDB?</h1><div> I would recommend you get this <b>mongodb://localhost:27017/basenmin</b> running first!</div> <p style="color:red"> '+err + '</p>');
      } else {
        assert.equal(null, err);
        insertHitCount(db, function () {
          db.close();
        });
        res.send('Amazing! Your are starting a hit count against a mongodb soon\n');
      }
    });
});

app.get('/nodeGet', function (req, res) {
  var response;
  MongoClient.connect(mongoDbUrl, function (err, db) {
    if(err){
      res.send('<h1>Seriously?? Connecting to non existing MongoDB?</h1><div> I would recommend you get this <b>mongodb://localhost:27017/basenmin</b> running first!</div> <p style="color:red"> '+err + '</p>');
    } else {
      assert.equal(null, err);
      findHitCount(db, function (result) {
        response = result;
        db.close();
        res.send('<h1>Amazing! finding all requests:</h1><h2>Number of requests:' + response.length + '</h2>' + JSON.stringify(response));
      });
    }
  });
});

app.listen(port);
console.log('Running on http://localhost:' + port);

//MongoDB methods
//#################
var mongoDbUrl = 'mongodb://mongo-db-host:27017/mongodb';
var collectionName = 'requests';
var insertHitCount = function(db, callback) {
  var date = new Date();
  db.collection(collectionName).insertOne({'timestamp': date }, function (err, result) {
    assert.equal(err, null);
    console.log("Inserted a document into the requests collection.");
    callback(result);
  });
};

var findHitCount = function(db, callback) {
  var result= [];
  var cursor =db.collection(collectionName).find( );
  cursor.each(function(err, doc) {
    assert.equal(err, null);
    if (doc != null) {
      console.log('Request at:' + doc.timestamp);
      result.push(doc.timestamp);
    } else {
      console.log('inside else method');
      callback(result);
    }
  });
};



