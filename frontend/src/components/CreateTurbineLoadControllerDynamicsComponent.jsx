import React, { Component } from 'react'
import TurbineLoadControllerDynamicsService from '../services/TurbineLoadControllerDynamicsService';

class CreateTurbineLoadControllerDynamicsComponent extends Component {
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
            TurbineLoadControllerDynamicsService.getTurbineLoadControllerDynamicsById(this.state.id).then( (res) =>{
                let turbineLoadControllerDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTurbineLoadControllerDynamics = (e) => {
        e.preventDefault();
        let turbineLoadControllerDynamics = {
                turbineLoadControllerDynamicsId: this.state.id,
            };
        console.log('turbineLoadControllerDynamics => ' + JSON.stringify(turbineLoadControllerDynamics));

        // step 5
        if(this.state.id === '_add'){
            turbineLoadControllerDynamics.turbineLoadControllerDynamicsId=''
            TurbineLoadControllerDynamicsService.createTurbineLoadControllerDynamics(turbineLoadControllerDynamics).then(res =>{
                this.props.history.push('/turbineLoadControllerDynamicss');
            });
        }else{
            TurbineLoadControllerDynamicsService.updateTurbineLoadControllerDynamics(turbineLoadControllerDynamics).then( res => {
                this.props.history.push('/turbineLoadControllerDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/turbineLoadControllerDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TurbineLoadControllerDynamics</h3>
        }else{
            return <h3 className="text-center">Update TurbineLoadControllerDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTurbineLoadControllerDynamics}>Save</button>
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

export default CreateTurbineLoadControllerDynamicsComponent
