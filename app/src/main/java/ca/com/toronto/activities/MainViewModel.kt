package ca.com.toronto.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.com.toronto.model.LocationsDetail

class MainViewModel : ViewModel() {

    private val _locationsLiveData = MutableLiveData<List<LocationsDetail>>().apply {
        value = listOf(
            LocationsDetail("Royal Ontario Museum", 43.6677291, -79.3956327),
            LocationsDetail("Casa Loma", 43.6781009, -79.4102353),
            LocationsDetail("Hockey Hall of Fame", 43.6472722, -79.3798789),
            LocationsDetail("Art Gallery of Ontario", 43.6536066, -79.3947014),
            LocationsDetail("Ripley's Aquarium of Canada", 43.6424537, -79.3883121),
            LocationsDetail("Distillery District", 43.6508959, -79.3606324),
            LocationsDetail("St. Lawrence Market South", 43.6490516, -79.3739628),
            LocationsDetail("Toronto Islands", 43.6208961, -79.3809296),
            LocationsDetail("Toronto Eaton Centre", 43.6544382, -79.3828881),
            LocationsDetail("Lake Ontario", 43.8334169, -78.2962345),
            LocationsDetail("Ontario Science Centre", 43.7164222, -79.3392783),
            LocationsDetail("Queen Street West", 43.6493583, -79.3962112),
            LocationsDetail("Bata Shoe Museum", 43.6672426, -79.4023547),
            LocationsDetail("High Park", 43.6467379, -79.4666694),
            LocationsDetail("Chinatown, Toronto", 43.6533055, -79.4018915),
            LocationsDetail("Yorkville, Toronto", 43.6724856, -79.3924302),
            LocationsDetail("Canada's Wonderland", 43.8430176, -79.5416512),
            LocationsDetail("Kensington Market", 43.6551171, -79.4079228),
            LocationsDetail("Toronto Zoo", 43.8176993, -79.1880792),
            LocationsDetail("Union Station", 43.6451893, -79.3828018),
            LocationsDetail("Black Creek Pioneer Village", 43.7734366, -79.5171418),
            LocationsDetail("Centreville Amusement Park", 43.6208031, -79.3769045),
            LocationsDetail("Allan Gardens", 43.6617585, -79.3768705),
            LocationsDetail("Nathan Phillips Square", 43.6525485, -79.3857005),
            LocationsDetail("Fort York", 43.6374165, -79.4086562),
            LocationsDetail("Toronto City Hall", 43.6534829, -79.3862826),
            LocationsDetail("Gardiner Museum", 43.6681404, -79.3952718),
            LocationsDetail("Edwards Gardens", 43.7334726, -79.3616114),
            LocationsDetail("Yonge-Dundas Square", 43.6560359, -79.3824244),
            LocationsDetail("Toronto Harbour", 43.6388346, -79.3840672),
            LocationsDetail("The Beaches", 43.6674604, -79.3153824),
            LocationsDetail("Textile Museum of Canada", 43.6545332, -79.3890797),
            LocationsDetail("Spadina House", 43.6790455, -79.4088208),
            LocationsDetail("Toronto waterfront", 43.6416441, -79.3788385),
            LocationsDetail("Gooderham Building", 43.6483281, -79.3750438),
            LocationsDetail("Hanlan's Point Beach", 43.6214627, -79.3963405),
            LocationsDetail("Roy Thomson Hall", 43.6465712, -79.3869448),
            LocationsDetail("Sugar Beach", 43.6427294, -79.3676444),
            LocationsDetail("Don Valley Brick Works", 43.6871996, -79.3667461),
            LocationsDetail("Harbourfront Centre", 43.6388617, -79.3827647),
            LocationsDetail("EdgeWalk at the CN Tower", 43.6422949, -79.3879505),
            LocationsDetail("Chinguacousy Park", 43.7253315, -79.7243438),
            LocationsDetail("Centennial Park", 43.6519906, -79.5913268),
            LocationsDetail("Woodbine Beach", 43.6617461, -79.3100127),
            LocationsDetail("Aga Khan Museum", 43.7257495, -79.3340014),
            LocationsDetail("Toronto Island Park", 43.6208961, -79.3809296),
            LocationsDetail("Player One Amusement Group", 43.6937843, -79.6276462),
            LocationsDetail("Riverdale Farm", 43.6671213, -79.3633138),
            LocationsDetail("Legoland Discovery Centre", 43.8251614, -79.5376193),
            LocationsDetail("CN Tower", 43.6425555, -79.3871045)
        )
    }

    internal val locationsLiveData: MutableLiveData<List<LocationsDetail>> = _locationsLiveData
}