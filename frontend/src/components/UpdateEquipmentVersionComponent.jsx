import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService';

class UpdateEquipmentVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateEquipmentVersion = this.updateEquipmentVersion.bind(this);

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

    componentDidMount(){
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

    updateEquipmentVersion = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        EquipmentVersionService.updateEquipmentVersion(equipmentVersion).then( res => {
            this.props.history.push('/equipmentVersions');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquipmentVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> baseUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> baseURIcore: </label>
                                            #formFields( $attribute, 'update')
                                            <label> baseURIoperation: </label>
                                            #formFields( $attribute, 'update')
                                            <label> baseURIshortCircuit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> date: </label>
                                            #formFields( $attribute, 'update')
                                            <label> differenceModelURI: </label>
                                            #formFields( $attribute, 'update')
                                            <label> entsoeUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> entsoeURIcore: </label>
                                            #formFields( $attribute, 'update')
                                            <label> entsoeURIoperation: </label>
                                            #formFields( $attribute, 'update')
                                            <label> entsoeURIshortCircuit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> modelDescriptionURI: </label>
                                            #formFields( $attribute, 'update')
                                            <label> namespaceRDF: </label>
                                            #formFields( $attribute, 'update')
                                            <label> namespaceUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquipmentVersion}>Save</button>
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

export default UpdateEquipmentVersionComponent
