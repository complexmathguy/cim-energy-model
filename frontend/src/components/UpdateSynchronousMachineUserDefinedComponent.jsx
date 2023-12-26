import React, { Component } from 'react'
import SynchronousMachineUserDefinedService from '../services/SynchronousMachineUserDefinedService';

class UpdateSynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                proprietary: ''
        }
        this.updateSynchronousMachineUserDefined = this.updateSynchronousMachineUserDefined.bind(this);

        this.changeproprietaryHandler = this.changeproprietaryHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineUserDefinedService.getSynchronousMachineUserDefinedById(this.state.id).then( (res) =>{
            let synchronousMachineUserDefined = res.data;
            this.setState({
                proprietary: synchronousMachineUserDefined.proprietary
            });
        });
    }

    updateSynchronousMachineUserDefined = (e) => {
        e.preventDefault();
        let synchronousMachineUserDefined = {
            synchronousMachineUserDefinedId: this.state.id,
            proprietary: this.state.proprietary
        };
        console.log('synchronousMachineUserDefined => ' + JSON.stringify(synchronousMachineUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineUserDefinedService.updateSynchronousMachineUserDefined(synchronousMachineUserDefined).then( res => {
            this.props.history.push('/synchronousMachineUserDefineds');
        });
    }

    changeproprietaryHandler= (event) => {
        this.setState({proprietary: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> proprietary: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineUserDefined}>Save</button>
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

export default UpdateSynchronousMachineUserDefinedComponent
