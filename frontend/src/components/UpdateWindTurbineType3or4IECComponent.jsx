import React, { Component } from 'react'
import WindTurbineType3or4IECService from '../services/WindTurbineType3or4IECService';

class UpdateWindTurbineType3or4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindTurbineType3or4IEC = this.updateWindTurbineType3or4IEC.bind(this);

    }

    componentDidMount(){
        WindTurbineType3or4IECService.getWindTurbineType3or4IECById(this.state.id).then( (res) =>{
            let windTurbineType3or4IEC = res.data;
            this.setState({
            });
        });
    }

    updateWindTurbineType3or4IEC = (e) => {
        e.preventDefault();
        let windTurbineType3or4IEC = {
            windTurbineType3or4IECId: this.state.id,
        };
        console.log('windTurbineType3or4IEC => ' + JSON.stringify(windTurbineType3or4IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindTurbineType3or4IECService.updateWindTurbineType3or4IEC(windTurbineType3or4IEC).then( res => {
            this.props.history.push('/windTurbineType3or4IECs');
        });
    }


    cancel(){
        this.props.history.push('/windTurbineType3or4IECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindTurbineType3or4IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindTurbineType3or4IEC}>Save</button>
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

export default UpdateWindTurbineType3or4IECComponent
