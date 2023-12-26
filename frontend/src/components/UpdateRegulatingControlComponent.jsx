import React, { Component } from 'react'
import RegulatingControlService from '../services/RegulatingControlService';

class UpdateRegulatingControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                mode: ''
        }
        this.updateRegulatingControl = this.updateRegulatingControl.bind(this);

        this.changemodeHandler = this.changemodeHandler.bind(this);
    }

    componentDidMount(){
        RegulatingControlService.getRegulatingControlById(this.state.id).then( (res) =>{
            let regulatingControl = res.data;
            this.setState({
                mode: regulatingControl.mode
            });
        });
    }

    updateRegulatingControl = (e) => {
        e.preventDefault();
        let regulatingControl = {
            regulatingControlId: this.state.id,
            mode: this.state.mode
        };
        console.log('regulatingControl => ' + JSON.stringify(regulatingControl));
        console.log('id => ' + JSON.stringify(this.state.id));
        RegulatingControlService.updateRegulatingControl(regulatingControl).then( res => {
            this.props.history.push('/regulatingControls');
        });
    }

    changemodeHandler= (event) => {
        this.setState({mode: event.target.value});
    }

    cancel(){
        this.props.history.push('/regulatingControls');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RegulatingControl</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> mode: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRegulatingControl}>Save</button>
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

export default UpdateRegulatingControlComponent
