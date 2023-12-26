import React, { Component } from 'react'
import TurbineGovernorDynamicsService from '../services/TurbineGovernorDynamicsService';

class CreateTurbineGovernorDynamicsComponent extends Component {
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
            TurbineGovernorDynamicsService.getTurbineGovernorDynamicsById(this.state.id).then( (res) =>{
                let turbineGovernorDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTurbineGovernorDynamics = (e) => {
        e.preventDefault();
        let turbineGovernorDynamics = {
                turbineGovernorDynamicsId: this.state.id,
            };
        console.log('turbineGovernorDynamics => ' + JSON.stringify(turbineGovernorDynamics));

        // step 5
        if(this.state.id === '_add'){
            turbineGovernorDynamics.turbineGovernorDynamicsId=''
            TurbineGovernorDynamicsService.createTurbineGovernorDynamics(turbineGovernorDynamics).then(res =>{
                this.props.history.push('/turbineGovernorDynamicss');
            });
        }else{
            TurbineGovernorDynamicsService.updateTurbineGovernorDynamics(turbineGovernorDynamics).then( res => {
                this.props.history.push('/turbineGovernorDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/turbineGovernorDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TurbineGovernorDynamics</h3>
        }else{
            return <h3 className="text-center">Update TurbineGovernorDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTurbineGovernorDynamics}>Save</button>
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

export default CreateTurbineGovernorDynamicsComponent
