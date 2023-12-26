import React, { Component } from 'react'
import ExcitationSystemDynamicsService from '../services/ExcitationSystemDynamicsService';

class CreateExcitationSystemDynamicsComponent extends Component {
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
            ExcitationSystemDynamicsService.getExcitationSystemDynamicsById(this.state.id).then( (res) =>{
                let excitationSystemDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcitationSystemDynamics = (e) => {
        e.preventDefault();
        let excitationSystemDynamics = {
                excitationSystemDynamicsId: this.state.id,
            };
        console.log('excitationSystemDynamics => ' + JSON.stringify(excitationSystemDynamics));

        // step 5
        if(this.state.id === '_add'){
            excitationSystemDynamics.excitationSystemDynamicsId=''
            ExcitationSystemDynamicsService.createExcitationSystemDynamics(excitationSystemDynamics).then(res =>{
                this.props.history.push('/excitationSystemDynamicss');
            });
        }else{
            ExcitationSystemDynamicsService.updateExcitationSystemDynamics(excitationSystemDynamics).then( res => {
                this.props.history.push('/excitationSystemDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excitationSystemDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcitationSystemDynamics</h3>
        }else{
            return <h3 className="text-center">Update ExcitationSystemDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcitationSystemDynamics}>Save</button>
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

export default CreateExcitationSystemDynamicsComponent
