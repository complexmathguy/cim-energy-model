import React, { Component } from 'react'
import AsynchronousMachineUserDefinedService from '../services/AsynchronousMachineUserDefinedService';

class UpdateAsynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateAsynchronousMachineUserDefined = this.updateAsynchronousMachineUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        AsynchronousMachineUserDefinedService.getAsynchronousMachineUserDefinedById(this.state.id).then( (res) =>{
            let asynchronousMachineUserDefined = res.data;
            this.setState({
                proprietary: asynchronousMachineUserDefined.proprietary
            });
        });
    }

    updateAsynchronousMachineUserDefined = (e) => {
        e.preventDefault();
        let asynchronousMachineUserDefined = {
            asynchronousMachineUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('asynchronousMachineUserDefined => ' + JSON.stringify(asynchronousMachineUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineUserDefinedService.updateAsynchronousMachineUserDefined(asynchronousMachineUserDefined).then( res => {
            this.props.history.push('/asynchronousMachineUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/asynchronousMachineUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachineUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachineUserDefined}>Save</button>
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

export default UpdateAsynchronousMachineUserDefinedComponent
