import React, { Component } from 'react'
import AnalogService from '../services/AnalogService';

class UpdateAnalogComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                positiveFlowIn: ''
        }
        this.updateAnalog = this.updateAnalog.bind(this);

        this.changepositiveFlowInHandler = this.changepositiveFlowInHandler.bind(this);
    }

    componentDidMount(){
        AnalogService.getAnalogById(this.state.id).then( (res) =>{
            let analog = res.data;
            this.setState({
                positiveFlowIn: analog.positiveFlowIn
            });
        });
    }

    updateAnalog = (e) => {
        e.preventDefault();
        let analog = {
            analogId: this.state.id,
            positiveFlowIn: this.state.positiveFlowIn
        };
        console.log('analog => ' + JSON.stringify(analog));
        console.log('id => ' + JSON.stringify(this.state.id));
        AnalogService.updateAnalog(analog).then( res => {
            this.props.history.push('/analogs');
        });
    }

    changepositiveFlowInHandler= (event) => {
        this.setState({positiveFlowIn: event.target.value});
    }

    cancel(){
        this.props.history.push('/analogs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Analog</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> positiveFlowIn: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAnalog}>Save</button>
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

export default UpdateAnalogComponent
