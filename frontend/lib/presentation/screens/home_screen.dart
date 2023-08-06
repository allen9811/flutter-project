import 'package:flutter/material.dart';
import 'package:mobile_app/presentation/widgets/bottom_navbar.dart';
import 'package:mobile_app/presentation/widgets/navbar.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: const BottomNavBar(),
      drawer: const NavBar(),
      appBar: AppBar(
        backgroundColor: Colors.blueGrey,
        title: const Text('PONTE A PRUEBA'),
        actions: [
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.notifications),
            color: Colors.black,
          )
        ],
      ),
    );
  }
}
