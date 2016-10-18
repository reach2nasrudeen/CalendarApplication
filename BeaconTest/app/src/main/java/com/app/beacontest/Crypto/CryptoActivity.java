package com.app.beacontest.Crypto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.beacontest.R;

public class CryptoActivity extends AppCompatActivity {
    static final String TAG = "AsymmetricAlgorithmRSA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto);
        final EditText editText = (EditText) findViewById(R.id.input);
        final TextView original = (TextView) findViewById(R.id.original);
        final TextView encode = (TextView) findViewById(R.id.encode);
        final TextView decode = (TextView) findViewById(R.id.decode);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputData = editText.getText().toString();
                original.setText(inputData);
                try {
                    encode.setText(CryptoHelper.encrypt(inputData));
                    decode.setText(CryptoHelper.decrypt(encode.getText().toString()));
                    Log.e("Encoded",encode.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
//        // Original text
//        String theTestText = "This is just a simple test!";
//        TextView tvorig = (TextView)findViewById(R.id.test);
//        tvorig.setText("\n[ORIGINAL]:\n" + theTestText + "\n");
//
//        // Generate key pair for 1024-bit RSA encryption and decryption
//        Key publicKey = null;
//        Key privateKey = null;
//        try {
//            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
//            kpg.initialize(1024);
//            KeyPair kp = kpg.genKeyPair();
//            publicKey = kp.getPublic();
//            privateKey = kp.getPrivate();
//        } catch (Exception e) {
//            Log.e(TAG, "RSA key pair error");
//        }
//
//        // Encode the original data with RSA private key
//        byte[] encodedBytes = null;
//        try {
//            Cipher c = Cipher.getInstance("RSA");
//            c.init(Cipher.ENCRYPT_MODE, privateKey);
//            encodedBytes = c.doFinal(theTestText.getBytes());
//        } catch (Exception e) {
//            Log.e(TAG, "RSA encryption error");
//        }
//        TextView tvencoded = (TextView)findViewById(R.id.tvencoded);
//        TextView tvdecoded = (TextView)findViewById(R.id.tvdecoded);
//        tvencoded.setText("[ENCODED]:\n" +
//                Base64.encodeToString(encodedBytes, Base64.DEFAULT) + "\n");
//
//        // Decode the encoded data with RSA public key
//        byte[] decodedBytes = null;
//        try {
//            Cipher c = Cipher.getInstance("RSA");
//            c.init(Cipher.DECRYPT_MODE, publicKey);
//            decodedBytes = c.doFinal(encodedBytes);
//        } catch (Exception e) {
//            Log.e(TAG, "RSA decryption error");
//        }
//
//        tvdecoded.setText("[DECODED]:\n" +new String(decodedBytes));
////                Base64.decode(decodedBytes, Base64.DEFAULT) + "\n");
    }
}
