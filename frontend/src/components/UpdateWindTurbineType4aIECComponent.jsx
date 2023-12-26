import React, { Component } from 'react'
import WindTurbineType4aIECService from '../services/WindTurbineType4aIECService';

class UpdateWindTurbineType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindTurbineType4aIEC = this.updateWindTurbineType4aIEC.bind(this);

    }

    componentDidMount(){
        WindTurbineType4aIECService.getWindTurbineType4aIECById(this.state.id).then( (res) =>{
            let windTurbineType4aIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindTurbineType4aIEC = (e) => {
        e.preventDefault();
        let windTurbineType4aIEC = {
            windTurbineType4aIECId: this.state.id,
        };
        console.log('windTurbineType4aIEC => ' + JSON.stringify(windTurbineType4aIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindTurbineType4aIECService.updateWindTurbineType4aIEC(windTurbineType4aIEC).then( res => {
            this.props.history.push('/windTurbineType4aIECs');
        });
    }


    cancel(){
        this.props.history.push('/windTurbineType4aIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindTurbineType4aIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindTurbineType4aIEC}>Save</button>
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

export default UpdateWindTurbineType4aIECComponent
