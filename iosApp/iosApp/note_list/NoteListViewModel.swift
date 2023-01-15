import Foundation
import shared

extension NoteListScreen {
    @MainActor class NoteListViewModel: ObservableObject {
        private var noteDataSource: NoteDataSource? = nil
        private var searchNote = SearchNotes()
        
        private var notes = [Note]()
        @Published private(set) var isSearchActive = false
        @Published private (set) var filteredNote = [Note]()
        @Published var searchText = "" {
            didSet {
                self.filteredNote=searchNote.execute(notes: self.notes, query: self.searchText)
                
            }
        }
        
        init(noteDataSource:NoteDataSource? = nil){
            self.noteDataSource = noteDataSource
        }
        
        
        func loadNotes(){
            noteDataSource?.getAllNotes(completionHandler: {notes,error in
                self.notes = notes ?? []
                self.filteredNote = self.notes
                })
        }
        
        
        func deleteNoteById(id:Int64?){
            if id != nil {
                noteDataSource?.deleteNoteById(id: id!, completionHandler: { error in
                    self.loadNotes()
                })
            }
        }
        
        func toggleIsSearchActive() {
            self.isSearchActive = !self.isSearchActive
            if !self.isSearchActive {
                 searchText = ""
                
                   }
            }
        
        func setDataSource(noteDataSource:NoteDataSource){
            self.noteDataSource = noteDataSource
        }
    }
}
