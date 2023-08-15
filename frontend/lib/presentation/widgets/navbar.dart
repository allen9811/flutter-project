import 'package:flutter/material.dart';

class NavBar extends StatelessWidget {
  const NavBar({super.key});

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(padding: EdgeInsets.zero, children: [
        UserAccountsDrawerHeader(
          accountName: const Text('Alexandro'),
          accountEmail: const Text('alexandrolengua@gmail.com'),
          currentAccountPicture: CircleAvatar(
            child: ClipOval(
              child: Image.network(
                'https://img2.freepng.es/20180329/zue/kisspng-computer-icons-user-profile-person-5abd85306ff7f7.0592226715223698404586.jpg',
                fit: BoxFit.cover,
              ),
            ),
          ),
          decoration: const BoxDecoration(
              color: Colors.blue,
              image: DecorationImage(
                  fit: BoxFit.cover,
                  image: NetworkImage(
                      'https://oflutter.com/wp-content/uploads/2021/02/profile-bg3.jpg'))),
        ),
        const ListTile(
          leading: Icon(Icons.favorite),
          title: Text('Favoritos'),
          onTap: null,
        ),
        const ListTile(
          leading: Icon(Icons.people),
          title: Text('Amigos'),
          onTap: null,
        ),
        const ListTile(
          leading: Icon(Icons.share),
          title: Text('Compartir'),
          onTap: null,
        ),
        const Divider(),
        const ListTile(
          leading: Icon(Icons.settings),
          title: Text('Ajustes'),
          onTap: null,
        ),
        ListTile(
          leading: const Icon(Icons.help),
          title: const Text('Ayuda'),
          onTap: () => null,
        ),
        ListTile(
          leading: const Icon(Icons.exit_to_app),
          title: const Text('Cerrar sesion'),
          onTap: () {
            Navigator.pushNamed(context, '/login_screen');
          },
        )
      ]),
    );
  }
}
