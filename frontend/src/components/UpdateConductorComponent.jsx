import React, { Component } from 'react'
import ConductorService from '../services/ConductorService';

class UpdateConductorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                length: ''
        }
        this.updateConductor = this.updateConductor.bind(this);

        this.changelengthHandler = this.changelengthHandler.bind(this);
    }

    componentDidMount(){
        ConductorService.getConductorById(this.state.id).then( (res) =>{
            let conductor = res.data;
            this.setState({
                length: conductor.length
            });
        });
    }

    updateConductor = (e) => {
        e.preventDefault();
        let conductor = {
            conductorId: this.state.id,
            length: this.state.length
        };
        console.log('conductor => ' + JSON.stringify(conductor));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConductorService.updateConductor(conductor).then( res => {
            this.props.history.push('/conductors');
        });
    }

    changelengthHandler= (event) => {
        this.setState({length: event.target.value});
    }

    cancel(){
        this.props.history.push('/conductors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Conductor</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> length: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConductor}>Save</button>
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

export default UpdateConductorComponent
