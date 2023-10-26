const admin = require("firebase-admin");

const serviceAccount = require("./token.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://curriculo-111e7.firebaseio.com",
});

module.exports = admin;