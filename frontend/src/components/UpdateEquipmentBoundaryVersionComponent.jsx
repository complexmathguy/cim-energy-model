import React, { Component } from 'react'
import EquipmentBoundaryVersionService from '../services/EquipmentBoundaryVersionService';

class UpdateEquipmentBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                baseUML: '',
                baseURI: '',
                date: '',
                differenceModelURI: '',
                entsoeUML: '',
                entsoeURIcore: '',
                entsoeURIoperation: '',
                modelDescriptionURI: '',
                namespaceRDF: '',
                namespaceUML: '',
                shortName: ''
        }
        this.updateEquipmentBoundaryVersion = this.updateEquipmentBoundaryVersion.bind(this);

        this.changebaseUMLHandler = this.changebaseUMLHandler.bind(this);
        this.changebaseURIHandler = this.changebaseURIHandler.bind(this);
        this.changedateHandler = this.changedateHandler.bind(this);
        this.changedifferenceModelURIHandler = this.changedifferenceModelURIHandler.bind(this);
        this.changeentsoeUMLHandler = this.changeentsoeUMLHandler.bind(this);
        this.changeentsoeURIcoreHandler = this.changeentsoeURIcoreHandler.bind(this);
        this.changeentsoeURIoperationHandler = this.changeentsoeURIoperationHandler.bind(this);
        this.changemodelDescriptionURIHandler = this.changemodelDescriptionURIHandler.bind(this);
        this.changenamespaceRDFHandler = this.changenamespaceRDFHandler.bind(this);
        this.changenamespaceUMLHandler = this.changenamespaceUMLHandler.bind(this);
        this.changeshortNameHandler = this.changeshortNameHandler.bind(this);
    }

    componentDidMount(){
        EquipmentBoundaryVersionService.getEquipmentBoundaryVersionById(this.state.id).then( (res) =>{
            let equipmentBoundaryVersion = res.data;
            this.setState({
                baseUML: equipmentBoundaryVersion.baseUML,
                baseURI: equipmentBoundaryVersion.baseURI,
                date: equipmentBoundaryVersion.date,
                differenceModelURI: equipmentBoundaryVersion.differenceModelURI,
                entsoeUML: equipmentBoundaryVersion.entsoeUML,
                entsoeURIcore: equipmentBoundaryVersion.entsoeURIcore,
                entsoeURIoperation: equipmentBoundaryVersion.entsoeURIoperation,
                modelDescriptionURI: equipmentBoundaryVersion.modelDescriptionURI,
                namespaceRDF: equipmentBoundaryVersion.namespaceRDF,
                namespaceUML: equipmentBoundaryVersion.namespaceUML,
                shortName: equipmentBoundaryVersion.shortName
            });
        });
    }

    updateEquipmentBoundaryVersion = (e) => {
        e.preventDefault();
        let equipmentBoundaryVersion = {
            equipmentBoundaryVersionId: this.state.id,
            baseUML: this.state.baseUML,
            baseURI: this.state.baseURI,
            date: this.state.date,
            differenceModelURI: this.state.differenceModelURI,
            entsoeUML: this.state.entsoeUML,
            entsoeURIcore: this.state.entsoeURIcore,
            entsoeURIoperation: this.state.entsoeURIoperation,
            modelDescriptionURI: this.state.modelDescriptionURI,
            namespaceRDF: this.state.namespaceRDF,
            namespaceUML: this.state.namespaceUML,
            shortName: this.state.shortName
        };
        console.log('equipmentBoundaryVersion => ' + JSON.stringify(equipmentBoundaryVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquipmentBoundaryVersionService.updateEquipmentBoundaryVersion(equipmentBoundaryVersion).then( res => {
            this.props.history.push('/equipmentBoundaryVersions');
        });
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
    changeentsoeURIcoreHandler= (event) => {
        this.setState({entsoeURIcore: event.target.value});
    }
    changeentsoeURIoperationHandler= (event) => {
        this.setState({entsoeURIoperation: event.target.value});
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
        this.props.history.push('/equipmentBoundaryVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquipmentBoundaryVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> baseUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> baseURI: </label>
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
                                            <label> modelDescriptionURI: </label>
                                            #formFields( $attribute, 'update')
                                            <label> namespaceRDF: </label>
                                            #formFields( $attribute, 'update')
                                            <label> namespaceUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> shortName: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquipmentBoundaryVersion}>Save</button>
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

export default UpdateEquipmentBoundaryVersionComponent
