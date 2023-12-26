import React, { Component } from 'react'
import TurbineGovernorUserDefinedService from '../services/TurbineGovernorUserDefinedService';

class UpdateTurbineGovernorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateTurbineGovernorUserDefined = this.updateTurbineGovernorUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        TurbineGovernorUserDefinedService.getTurbineGovernorUserDefinedById(this.state.id).then( (res) =>{
            let turbineGovernorUserDefined = res.data;
            this.setState({
                proprietary: turbineGovernorUserDefined.proprietary
            });
        });
    }

    updateTurbineGovernorUserDefined = (e) => {
        e.preventDefault();
        let turbineGovernorUserDefined = {
            turbineGovernorUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('turbineGovernorUserDefined => ' + JSON.stringify(turbineGovernorUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        TurbineGovernorUserDefinedService.updateTurbineGovernorUserDefined(turbineGovernorUserDefined).then( res => {
            this.props.history.push('/turbineGovernorUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/turbineGovernorUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TurbineGovernorUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTurbineGovernorUserDefined}>Save</button>
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

export default UpdateTurbineGovernorUserDefinedComponent
