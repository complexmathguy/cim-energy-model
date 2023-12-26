import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService';

class CreateEquipmentVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                baseUML: '',
                baseURIcore: '',
                baseURIoperation: '',
                baseURIshortCircuit: '',
                date: '',
                differenceModelURI: '',
                entsoeUML: '',
                entsoeURIcore: '',
                entsoeURIoperation: '',
                entsoeURIshortCircuit: '',
                modelDescriptionURI: '',
                namespaceRDF: '',
                namespaceUML: '',
                shortName: ''
        }
        this.changebaseUMLHandler = this.changebaseUMLHandler.bind(this);
        this.changebaseURIcoreHandler = this.changebaseURIcoreHandler.bind(this);
        this.changebaseURIoperationHandler = this.changebaseURIoperationHandler.bind(this);
        this.changebaseURIshortCircuitHandler = this.changebaseURIshortCircuitHandler.bind(this);
        this.changedateHandler = this.changedateHandler.bind(this);
        this.changedifferenceModelURIHandler = this.changedifferenceModelURIHandler.bind(this);
        this.changeentsoeUMLHandler = this.changeentsoeUMLHandler.bind(this);
        this.changeentsoeURIcoreHandler = this.changeentsoeURIcoreHandler.bind(this);
        this.changeentsoeURIoperationHandler = this.changeentsoeURIoperationHandler.bind(this);
        this.changeentsoeURIshortCircuitHandler = this.changeentsoeURIshortCircuitHandler.bind(this);
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
            EquipmentVersionService.getEquipmentVersionById(this.state.id).then( (res) =>{
                let equipmentVersion = res.data;
                this.setState({
                    baseUML: equipmentVersion.baseUML,
                    baseURIcore: equipmentVersion.baseURIcore,
                    baseURIoperation: equipmentVersion.baseURIoperation,
                    baseURIshortCircuit: equipmentVersion.baseURIshortCircuit,
                    date: equipmentVersion.date,
                    differenceModelURI: equipmentVersion.differenceModelURI,
                    entsoeUML: equipmentVersion.entsoeUML,
                    entsoeURIcore: equipmentVersion.entsoeURIcore,
                    entsoeURIoperation: equipmentVersion.entsoeURIoperation,
                    entsoeURIshortCircuit: equipmentVersion.entsoeURIshortCircuit,
                    modelDescriptionURI: equipmentVersion.modelDescriptionURI,
                    namespaceRDF: equipmentVersion.namespaceRDF,
                    namespaceUML: equipmentVersion.namespaceUML,
                    shortName: equipmentVersion.shortName
                });
            });
        }        
    }
    saveOrUpdateEquipmentVersion = (e) => {
        e.preventDefault();
        let equipmentVersion = {
                equipmentVersionId: this.state.id,
                baseUML: this.state.baseUML,
                baseURIcore: this.state.baseURIcore,
                baseURIoperation: this.state.baseURIoperation,
                baseURIshortCircuit: this.state.baseURIshortCircuit,
                date: this.state.date,
                differenceModelURI: this.state.differenceModelURI,
                entsoeUML: this.state.entsoeUML,
                entsoeURIcore: this.state.entsoeURIcore,
                entsoeURIoperation: this.state.entsoeURIoperation,
                entsoeURIshortCircuit: this.state.entsoeURIshortCircuit,
                modelDescriptionURI: this.state.modelDescriptionURI,
                namespaceRDF: this.state.namespaceRDF,
                namespaceUML: this.state.namespaceUML,
                shortName: this.state.shortName
            };
        console.log('equipmentVersion => ' + JSON.stringify(equipmentVersion));

        // step 5
        if(this.state.id === '_add'){
            equipmentVersion.equipmentVersionId=''
            EquipmentVersionService.createEquipmentVersion(equipmentVersion).then(res =>{
                this.props.history.push('/equipmentVersions');
            });
        }else{
            EquipmentVersionService.updateEquipmentVersion(equipmentVersion).then( res => {
                this.props.history.push('/equipmentVersions');
            });
        }
    }
    
    changebaseUMLHandler= (event) => {
        this.setState({baseUML: event.target.value});
    }
    changebaseURIcoreHandler= (event) => {
        this.setState({baseURIcore: event.target.value});
    }
    changebaseURIoperationHandler= (event) => {
        this.setState({baseURIoperation: event.target.value});
    }
    changebaseURIshortCircuitHandler= (event) => {
        this.setState({baseURIshortCircuit: event.target.value});
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
    changeentsoeURIcoreHandler= (event) => {
        this.setState({entsoeURIcore: event.target.value});
    }
    changeentsoeURIoperationHandler= (event) => {
        this.setState({entsoeURIoperation: event.target.value});
    }
    changeentsoeURIshortCircuitHandler= (event) => {
        this.setState({entsoeURIshortCircuit: event.target.value});
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
        this.props.history.push('/equipmentVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquipmentVersion</h3>
        }else{
            return <h3 className="text-center">Update EquipmentVersion</h3>
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
                                            <label> baseURIcore: </label>
                                            #formFields( $attribute, 'create')
                                            <label> baseURIoperation: </label>
                                            #formFields( $attribute, 'create')
                                            <label> baseURIshortCircuit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> date: </label>
                                            #formFields( $attribute, 'create')
                                            <label> differenceModelURI: </label>
                                            #formFields( $attribute, 'create')
                                            <label> entsoeUML: </label>
                                            #formFields( $attribute, 'create')
                                            <label> entsoeURIcore: </label>
                                            #formFields( $attribute, 'create')
                                            <label> entsoeURIoperation: </label>
                                            #formFields( $attribute, 'create')
                                            <label> entsoeURIshortCircuit: </label>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquipmentVersion}>Save</button>
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

export default CreateEquipmentVersionComponent
