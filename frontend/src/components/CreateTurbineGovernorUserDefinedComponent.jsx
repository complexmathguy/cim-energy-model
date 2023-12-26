import React, { Component } from 'react'
import TurbineGovernorUserDefinedService from '../services/TurbineGovernorUserDefinedService';

class CreateTurbineGovernorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TurbineGovernorUserDefinedService.getTurbineGovernorUserDefinedById(this.state.id).then( (res) =>{
                let turbineGovernorUserDefined = res.data;
                this.setState({
                    proprietary: turbineGovernorUserDefined.proprietary
                });
            });
        }        
    }
    saveOrUpdateTurbineGovernorUserDefined = (e) => {
        e.preventDefault();
        let turbineGovernorUserDefined = {
                turbineGovernorUserDefinedId: this.state.id,
                proprietary: this.state.proprietary
            };
        console.log('turbineGovernorUserDefined => ' + JSON.stringify(turbineGovernorUserDefined));

        // step 5
        if(this.state.id === '_add'){
            turbineGovernorUserDefined.turbineGovernorUserDefinedId=''
            TurbineGovernorUserDefinedService.createTurbineGovernorUserDefined(turbineGovernorUserDefined).then(res =>{
                this.props.history.push('/turbineGovernorUserDefineds');
            });
        }else{
            TurbineGovernorUserDefinedService.updateTurbineGovernorUserDefined(turbineGovernorUserDefined).then( res => {
                this.props.history.push('/turbineGovernorUserDefineds');
            });
        }
    }
    
    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/turbineGovernorUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TurbineGovernorUserDefined</h3>
        }else{
            return <h3 className="text-center">Update TurbineGovernorUserDefined</h3>
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
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTurbineGovernorUserDefined}>Save</button>
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

export default CreateTurbineGovernorUserDefinedComponent
