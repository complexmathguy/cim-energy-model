import React, { Component } from 'react'
import SynchronousMachineSimplifiedService from '../services/SynchronousMachineSimplifiedService';

class UpdateSynchronousMachineSimplifiedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSynchronousMachineSimplified = this.updateSynchronousMachineSimplified.bind(this);

    }

    componentDidMount(){
        SynchronousMachineSimplifiedService.getSynchronousMachineSimplifiedById(this.state.id).then( (res) =>{
            let synchronousMachineSimplified = res.data;
            this.setState({
            });
        });
    }

    updateSynchronousMachineSimplified = (e) => {
        e.preventDefault();
        let synchronousMachineSimplified = {
            synchronousMachineSimplifiedId: this.state.id,
        };
        console.log('synchronousMachineSimplified => ' + JSON.stringify(synchronousMachineSimplified));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineSimplifiedService.updateSynchronousMachineSimplified(synchronousMachineSimplified).then( res => {
            this.props.history.push('/synchronousMachineSimplifieds');
        });
    }


    cancel(){
        this.props.history.push('/synchronousMachineSimplifieds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineSimplified</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineSimplified}>Save</button>
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

export default UpdateSynchronousMachineSimplifiedComponent
