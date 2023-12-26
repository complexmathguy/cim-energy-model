import React, { Component } from 'react'
import ConductingEquipmentService from '../services/ConductingEquipmentService';

class CreateConductingEquipmentComponent extends Component {
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
            ConductingEquipmentService.getConductingEquipmentById(this.state.id).then( (res) =>{
                let conductingEquipment = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateConductingEquipment = (e) => {
        e.preventDefault();
        let conductingEquipment = {
                conductingEquipmentId: this.state.id,
            };
        console.log('conductingEquipment => ' + JSON.stringify(conductingEquipment));

        // step 5
        if(this.state.id === '_add'){
            conductingEquipment.conductingEquipmentId=''
            ConductingEquipmentService.createConductingEquipment(conductingEquipment).then(res =>{
                this.props.history.push('/conductingEquipments');
            });
        }else{
            ConductingEquipmentService.updateConductingEquipment(conductingEquipment).then( res => {
                this.props.history.push('/conductingEquipments');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/conductingEquipments');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ConductingEquipment</h3>
        }else{
            return <h3 className="text-center">Update ConductingEquipment</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConductingEquipment}>Save</button>
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

export default CreateConductingEquipmentComponent
