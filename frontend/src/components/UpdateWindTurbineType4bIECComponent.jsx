import React, { Component } from 'react'
import WindTurbineType4bIECService from '../services/WindTurbineType4bIECService';

class UpdateWindTurbineType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindTurbineType4bIEC = this.updateWindTurbineType4bIEC.bind(this);

    }

    componentDidMount(){
        WindTurbineType4bIECService.getWindTurbineType4bIECById(this.state.id).then( (res) =>{
            let windTurbineType4bIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindTurbineType4bIEC = (e) => {
        e.preventDefault();
        let windTurbineType4bIEC = {
            windTurbineType4bIECId: this.state.id,
        };
        console.log('windTurbineType4bIEC => ' + JSON.stringify(windTurbineType4bIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindTurbineType4bIECService.updateWindTurbineType4bIEC(windTurbineType4bIEC).then( res => {
            this.props.history.push('/windTurbineType4bIECs');
        });
    }


    cancel(){
        this.props.history.push('/windTurbineType4bIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindTurbineType4bIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindTurbineType4bIEC}>Save</button>
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

export default UpdateWindTurbineType4bIECComponent
