import React, { Component } from 'react'
import DCConductingEquipmentService from '../services/DCConductingEquipmentService';

class CreateDCConductingEquipmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DCConductingEquipmentService.getDCConductingEquipmentById(this.state.id).then( (res) =>{
                let dCConductingEquipment = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCConductingEquipment = (e) => {
        e.preventDefault();
        let dCConductingEquipment = {
                dCConductingEquipmentId: this.state.id,
            };
        console.log('dCConductingEquipment => ' + JSON.stringify(dCConductingEquipment));

        // step 5
        if(this.state.id === '_add'){
            dCConductingEquipment.dCConductingEquipmentId=''
            DCConductingEquipmentService.createDCConductingEquipment(dCConductingEquipment).then(res =>{
                this.props.history.push('/dCConductingEquipments');
            });
        }else{
            DCConductingEquipmentService.updateDCConductingEquipment(dCConductingEquipment).then( res => {
                this.props.history.push('/dCConductingEquipments');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCConductingEquipments');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCConductingEquipment</h3>
        }else{
            return <h3 className="text-center">Update DCConductingEquipment</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCConductingEquipment}>Save</button>
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

export default CreateDCConductingEquipmentComponent
