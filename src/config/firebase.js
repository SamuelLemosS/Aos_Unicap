const admin = require("firebase-admin");

//const serviceAccount = require("GOOGLE_APPLICATION_CREDENTIALS");

admin.initializeApp({
  credential: admin.credential.applicationDefault(),
  databaseURL: "https://curriculo-111e7.firebaseio.com",
});

module.exports = admin;