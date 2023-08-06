import 'package:flutter/material.dart';
import 'package:google_nav_bar/google_nav_bar.dart';

class BottomNavBar extends StatelessWidget {
  const BottomNavBar({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.black,
      child: const Padding(
        padding: EdgeInsets.symmetric(horizontal: 15, vertical: 20),
        child: GNav(
            selectedIndex: 1,
            backgroundColor: Colors.black,
            color: Colors.white,
            hoverColor: Colors.grey,
            activeColor: Colors.white,
            padding: EdgeInsets.all(12),
            tabs: [
              GButton(
                icon: Icons.search,
                text: 'Buscar',
              ),
              GButton(icon: Icons.home, text: 'Inicio'),
              GButton(
                icon: Icons.settings,
                text: 'Ajustes',
              )
            ]),
      ),
    );
  }
}
