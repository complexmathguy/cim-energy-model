import React, { Component } from 'react'
import NonlinearShuntCompensatorService from '../services/NonlinearShuntCompensatorService';

class UpdateNonlinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateNonlinearShuntCompensator = this.updateNonlinearShuntCompensator.bind(this);

    }

    componentDidMount(){
        NonlinearShuntCompensatorService.getNonlinearShuntCompensatorById(this.state.id).then( (res) =>{
            let nonlinearShuntCompensator = res.data;
            this.setState({
            });
        });
    }

    updateNonlinearShuntCompensator = (e) => {
        e.preventDefault();
        let nonlinearShuntCompensator = {
            nonlinearShuntCompensatorId: this.state.id,
        };
        console.log('nonlinearShuntCompensator => ' + JSON.stringify(nonlinearShuntCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        NonlinearShuntCompensatorService.updateNonlinearShuntCompensator(nonlinearShuntCompensator).then( res => {
            this.props.history.push('/nonlinearShuntCompensators');
        });
    }


    cancel(){
        this.props.history.push('/nonlinearShuntCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NonlinearShuntCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNonlinearShuntCompensator}>Save</button>
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

export default UpdateNonlinearShuntCompensatorComponent
