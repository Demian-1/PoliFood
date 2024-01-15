@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package mx.ipn.escom.acuaytes.polifood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.ipn.escom.acuaytes.polifood.data.Product
import mx.ipn.escom.acuaytes.polifood.data.products
import mx.ipn.escom.acuaytes.polifood.ui.theme.PoliFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoliFoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Login(
    modifier: Modifier = Modifier
) {
    var usr by remember { mutableStateOf("") }
    var pswd by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "PoliFood", style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = usr,
            onValueChange = { usr = it },
            label = { Text("Correo") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = pswd,
            onValueChange = { pswd = it },
            label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Default.Check
                else Icons.Default.Clear

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        OutlinedButton(
            onClick = { },
            modifier = modifier
                .widthIn(min = 250.dp)
                .padding(vertical = 8.dp)
        ) {
            Text("Recuperar contraseña")
        }
        OutlinedButton(
            onClick = { },
            modifier = modifier
                .widthIn(min = 250.dp)
                .padding(vertical = 8.dp)
        ) {
            Text("Registrarse")
        }
        Button(
            onClick = { },
            modifier = modifier
                .widthIn(min = 250.dp)
                .padding(vertical = 8.dp)
        ) {
            Text("Iniciar Sesion")
        }

    }
}

@Composable
fun Register(
    modifier: Modifier = Modifier
) {
    var usr by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var pswd by remember { mutableStateOf("") }
    var pswdConf by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordConfVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "PoliFood", style = MaterialTheme.typography.displaySmall)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = usr,
            onValueChange = { usr = it },
            label = { Text("Correo") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = pswd,
            onValueChange = { pswd = it },
            label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Default.Check
                else Icons.Default.Info

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = pswdConf,
            onValueChange = { pswdConf = it },
            label = { Text("Confirmar Contraseña") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            visualTransformation = if (passwordConfVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordConfVisible)
                    Icons.Default.Check
                else Icons.Default.Info

                // Please provide localized description for accessibility services
                val description = if (passwordConfVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordConfVisible = !passwordConfVisible}){
                    Icon(imageVector  = image, description)
                }
            },modifier = Modifier
                .padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Telefono") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = modifier
                .widthIn(min = 250.dp)
                .padding(vertical = 8.dp)
        ) {
            Text("Registrarse")
        }


    }
}

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    var opc by remember { mutableStateOf("Catalogo") }
    var backButton by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "PoliFood",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = { if (backButton) {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceAround, // Ajusta la distribución horizontal
                    verticalAlignment = Alignment.CenterVertically // Ajusta la alineación vertical
                ) {
                    // Composables dentro del Row
                    Box(
                        modifier = Modifier
                            .clickable { opc = "Catalogo" }
                            .size(69.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.shopping_bag_24px),
                                contentDescription = null
                            )
                            Text(
                                text = "Catalogo",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .clickable { opc = "Carrito" }
                            .size(69.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.shopping_cart_24px),
                                contentDescription = null
                            )
                            Text(
                                text = "Carrito",
                                style = MaterialTheme.typography.labelSmall
                            )
                        }
                    }

                    // Agrega más composables según sea necesario
                }
            }
        }
    ) { innerPadding ->
        if(opc.equals("Catalogo")) {
            Catalogo(innerPadding)
        }else if(opc.equals("Carrito")) {
            Carrito(innerPadding = innerPadding)
        }else {
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                    """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button Error times.
                """.trimIndent(),
                )
            }
        }
    }
}

@Composable
fun Carrito(
    innerPadding: PaddingValues = PaddingValues(16.dp),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text =
            """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button Carrito times.
                """.trimIndent(),
        )
    }
}

@Composable
fun Catalogo(
    innerPadding: PaddingValues = PaddingValues(16.dp),
    modifier: Modifier = Modifier
) {
        LazyColumn(
            contentPadding = innerPadding
        ) {

            items(products) {
                ProductItem(
                    product = it,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
}

@Composable
fun ProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            ProductIcon(product.imageResourceId)
            ProductInformation(product.name, product.price)
        }
    }
}

@Composable
fun ProductIcon(
    @DrawableRes productIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(productIcon),

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}

@Composable
fun ProductInformation(
    productName: String,
    productPrice: Double,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = productName,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.price, productPrice),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun GreetingPreview() {
    PoliFoodTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Catalogo()
        }
    }
}