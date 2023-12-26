import React, { Component } from 'react'
import EquivalentEquipmentService from '../services/EquivalentEquipmentService';

class CreateEquivalentEquipmentComponent extends Component {
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
            EquivalentEquipmentService.getEquivalentEquipmentById(this.state.id).then( (res) =>{
                let equivalentEquipment = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquivalentEquipment = (e) => {
        e.preventDefault();
        let equivalentEquipment = {
                equivalentEquipmentId: this.state.id,
            };
        console.log('equivalentEquipment => ' + JSON.stringify(equivalentEquipment));

        // step 5
        if(this.state.id === '_add'){
            equivalentEquipment.equivalentEquipmentId=''
            EquivalentEquipmentService.createEquivalentEquipment(equivalentEquipment).then(res =>{
                this.props.history.push('/equivalentEquipments');
            });
        }else{
            EquivalentEquipmentService.updateEquivalentEquipment(equivalentEquipment).then( res => {
                this.props.history.push('/equivalentEquipments');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equivalentEquipments');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquivalentEquipment</h3>
        }else{
            return <h3 className="text-center">Update EquivalentEquipment</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquivalentEquipment}>Save</button>
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

export default CreateEquivalentEquipmentComponent
