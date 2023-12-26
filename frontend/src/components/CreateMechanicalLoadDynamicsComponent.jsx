import React, { Component } from 'react'
import MechanicalLoadDynamicsService from '../services/MechanicalLoadDynamicsService';

class CreateMechanicalLoadDynamicsComponent extends Component {
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
            MechanicalLoadDynamicsService.getMechanicalLoadDynamicsById(this.state.id).then( (res) =>{
                let mechanicalLoadDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMechanicalLoadDynamics = (e) => {
        e.preventDefault();
        let mechanicalLoadDynamics = {
                mechanicalLoadDynamicsId: this.state.id,
            };
        console.log('mechanicalLoadDynamics => ' + JSON.stringify(mechanicalLoadDynamics));

        // step 5
        if(this.state.id === '_add'){
            mechanicalLoadDynamics.mechanicalLoadDynamicsId=''
            MechanicalLoadDynamicsService.createMechanicalLoadDynamics(mechanicalLoadDynamics).then(res =>{
                this.props.history.push('/mechanicalLoadDynamicss');
            });
        }else{
            MechanicalLoadDynamicsService.updateMechanicalLoadDynamics(mechanicalLoadDynamics).then( res => {
                this.props.history.push('/mechanicalLoadDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/mechanicalLoadDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MechanicalLoadDynamics</h3>
        }else{
            return <h3 className="text-center">Update MechanicalLoadDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMechanicalLoadDynamics}>Save</button>
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

export default CreateMechanicalLoadDynamicsComponent
