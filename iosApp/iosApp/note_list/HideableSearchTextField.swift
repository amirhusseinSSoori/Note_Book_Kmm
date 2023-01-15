import SwiftUI

struct HideableSearchTextField<Destination:View>: View {
    
    var onSearchToggled: () -> Void
    var destinnationProvider: () -> Destination
    var isSearchActive:Bool
    @Binding var searchText:String
    
    var body: some View {
        HStack{
            TextField("Search....",text:$searchText)
                .textFieldStyle(.roundedBorder)
                .opacity(isSearchActive ? 1 : 0)
            
            
            if(!isSearchActive){
                Spacer()
            }
            
            Button(action:onSearchToggled){
                Image(systemName: isSearchActive ? "xmark" : "magnifyingglass")
            }
            
            NavigationLink(destination: destinnationProvider()){
                Image(systemName: "plus")
            }
    

        }
    }
}

struct HideableSearchTextField_Previews: PreviewProvider {
    static var previews: some View {
        HideableSearchTextField(onSearchToggled: {
       
            
        }, destinnationProvider: {
            EmptyView()
            
        }, isSearchActive: true, searchText: .constant("search"))
    }
}
