import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

class LoginScreen extends StatelessWidget {
  const LoginScreen({super.key});

  @override
  Widget build(BuildContext context) {
    dynamic size = MediaQuery.of(context).size;
    return Scaffold(
      backgroundColor: Colors.blueGrey[200],
      body: Form(
        child: Stack(children: [
          SizedBox(
            width: size.width,
            height: size.height,
            child: Align(
              alignment: Alignment.center,
              child: Container(
                width: size.width * 0.85,
                padding:
                    const EdgeInsets.symmetric(horizontal: 20, vertical: 80),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(10),
                ),
                child: SingleChildScrollView(
                    child: Center(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      const Center(
                        child: Text(
                          'Login',
                          style: TextStyle(
                              fontSize: 30, fontWeight: FontWeight.bold),
                        ),
                      ),
                      SizedBox(
                        height: size.height * 0.04,
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                            hintText: 'Email',
                            isDense: true,
                            border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10))),
                      ),
                      SizedBox(
                        height: size.height * 0.03,
                      ),
                      TextFormField(
                        decoration: InputDecoration(
                            hintText: 'Password',
                            isDense: true,
                            border: OutlineInputBorder(
                                borderRadius: BorderRadius.circular(10))),
                      ),
                      SizedBox(
                        height: size.height * 0.04,
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          FilledButton(
                              onPressed: () {},
                              child: const Text(
                                'Login',
                                style: TextStyle(fontSize: 20),
                              )),
                        ],
                      ),
                      SizedBox(
                        height: size.height * 0.02,
                      ),
                      const Center(
                        child: Text(
                          'Redes Sociales',
                          style: TextStyle(
                              fontSize: 16, fontFamily: "Poppins-Medium"),
                        ),
                      ),
                      SizedBox(
                        height: size.height * 0.02,
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          SizedBox(
                            width: size.width * 0.06,
                          ),
                          const Icon(
                            FontAwesomeIcons.facebook,
                            size: 30,
                            color: Colors.blue,
                          ),
                          SizedBox(
                            width: size.width * 0.06,
                          ),
                          const Icon(
                            FontAwesomeIcons.twitter,
                            size: 30,
                            color: Colors.blue,
                          ),
                          SizedBox(
                            width: size.width * 0.06,
                          ),
                          const Icon(
                            FontAwesomeIcons.linkedin,
                            size: 30,
                            color: Colors.blue,
                          ),
                          SizedBox(
                            width: size.width * 0.06,
                          ),
                          const Icon(FontAwesomeIcons.apple,
                              size: 30, color: Colors.black)
                        ],
                      )
                    ],
                  ),
                )),
              ),
            ),
          ),
        ]),
      ),
    );
  }
}
