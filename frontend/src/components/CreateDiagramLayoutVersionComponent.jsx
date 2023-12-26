import React, { Component } from 'react'
import DiagramLayoutVersionService from '../services/DiagramLayoutVersionService';

class CreateDiagramLayoutVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                baseUML: '',
                baseURI: '',
                date: '',
                differenceModelURI: '',
                entsoeUML: '',
                entsoeURI: '',
                modelDescriptionURI: '',
                namespaceRDF: '',
                namespaceUML: '',
                shortName: ''
        }
        this.changebaseUMLHandler = this.changebaseUMLHandler.bind(this);
        this.changebaseURIHandler = this.changebaseURIHandler.bind(this);
        this.changedateHandler = this.changedateHandler.bind(this);
        this.changedifferenceModelURIHandler = this.changedifferenceModelURIHandler.bind(this);
        this.changeentsoeUMLHandler = this.changeentsoeUMLHandler.bind(this);
        this.changeentsoeURIHandler = this.changeentsoeURIHandler.bind(this);
        this.changemodelDescriptionURIHandler = this.changemodelDescriptionURIHandler.bind(this);
        this.changenamespaceRDFHandler = this.changenamespaceRDFHandler.bind(this);
        this.changenamespaceUMLHandler = this.changenamespaceUMLHandler.bind(this);
        this.changeshortNameHandler = this.changeshortNameHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiagramLayoutVersionService.getDiagramLayoutVersionById(this.state.id).then( (res) =>{
                let diagramLayoutVersion = res.data;
                this.setState({
                    baseUML: diagramLayoutVersion.baseUML,
                    baseURI: diagramLayoutVersion.baseURI,
                    date: diagramLayoutVersion.date,
                    differenceModelURI: diagramLayoutVersion.differenceModelURI,
                    entsoeUML: diagramLayoutVersion.entsoeUML,
                    entsoeURI: diagramLayoutVersion.entsoeURI,
                    modelDescriptionURI: diagramLayoutVersion.modelDescriptionURI,
                    namespaceRDF: diagramLayoutVersion.namespaceRDF,
                    namespaceUML: diagramLayoutVersion.namespaceUML,
                    shortName: diagramLayoutVersion.shortName
                });
            });
        }        
    }
    saveOrUpdateDiagramLayoutVersion = (e) => {
        e.preventDefault();
        let diagramLayoutVersion = {
                diagramLayoutVersionId: this.state.id,
                baseUML: this.state.baseUML,
                baseURI: this.state.baseURI,
                date: this.state.date,
                differenceModelURI: this.state.differenceModelURI,
                entsoeUML: this.state.entsoeUML,
                entsoeURI: this.state.entsoeURI,
                modelDescriptionURI: this.state.modelDescriptionURI,
                namespaceRDF: this.state.namespaceRDF,
                namespaceUML: this.state.namespaceUML,
                shortName: this.state.shortName
            };
        console.log('diagramLayoutVersion => ' + JSON.stringify(diagramLayoutVersion));

        // step 5
        if(this.state.id === '_add'){
            diagramLayoutVersion.diagramLayoutVersionId=''
            DiagramLayoutVersionService.createDiagramLayoutVersion(diagramLayoutVersion).then(res =>{
                this.props.history.push('/diagramLayoutVersions');
            });
        }else{
            DiagramLayoutVersionService.updateDiagramLayoutVersion(diagramLayoutVersion).then( res => {
                this.props.history.push('/diagramLayoutVersions');
            });
        }
    }
    
    changebaseUMLHandler= (event) => {
        this.setState({baseUML: event.target.value});
    }
    changebaseURIHandler= (event) => {
        this.setState({baseURI: event.target.value});
    }
    changedateHandler= (event) => {
        this.setState({date: event.target.value});
    }
    changedifferenceModelURIHandler= (event) => {
        this.setState({differenceModelURI: event.target.value});
    }
    changeentsoeUMLHandler= (event) => {
        this.setState({entsoeUML: event.target.value});
    }
    changeentsoeURIHandler= (event) => {
        this.setState({entsoeURI: event.target.value});
    }
    changemodelDescriptionURIHandler= (event) => {
        this.setState({modelDescriptionURI: event.target.value});
    }
    changenamespaceRDFHandler= (event) => {
        this.setState({namespaceRDF: event.target.value});
    }
    changenamespaceUMLHandler= (event) => {
        this.setState({namespaceUML: event.target.value});
    }
    changeshortNameHandler= (event) => {
        this.setState({shortName: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagramLayoutVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramLayoutVersion</h3>
        }else{
            return <h3 className="text-center">Update DiagramLayoutVersion</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> baseUML: </label>
                                            #formFields( $attribute, 'create')
                                            <label> baseURI: </label>
                                            #formFields( $attribute, 'create')
                                            <label> date: </label>
                                            #formFields( $attribute, 'create')
                                            <label> differenceModelURI: </label>
                                            #formFields( $attribute, 'create')
                                            <label> entsoeUML: </label>
                                            #formFields( $attribute, 'create')
                                            <label> entsoeURI: </label>
                                            #formFields( $attribute, 'create')
                                            <label> modelDescriptionURI: </label>
                                            #formFields( $attribute, 'create')
                                            <label> namespaceRDF: </label>
                                            #formFields( $attribute, 'create')
                                            <label> namespaceUML: </label>
                                            #formFields( $attribute, 'create')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramLayoutVersion}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateDiagramLayoutVersionComponent
