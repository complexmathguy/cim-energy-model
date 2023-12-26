import React, { Component } from 'react'
import WindGenTurbineType1IECService from '../services/WindGenTurbineType1IECService';

class UpdateWindGenTurbineType1IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindGenTurbineType1IEC = this.updateWindGenTurbineType1IEC.bind(this);

    }

    componentDidMount(){
        WindGenTurbineType1IECService.getWindGenTurbineType1IECById(this.state.id).then( (res) =>{
            let windGenTurbineType1IEC = res.data;
            this.setState({
            });
        });
    }

    updateWindGenTurbineType1IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType1IEC = {
            windGenTurbineType1IECId: this.state.id,
        };
        console.log('windGenTurbineType1IEC => ' + JSON.stringify(windGenTurbineType1IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType1IECService.updateWindGenTurbineType1IEC(windGenTurbineType1IEC).then( res => {
            this.props.history.push('/windGenTurbineType1IECs');
        });
    }


    cancel(){
        this.props.history.push('/windGenTurbineType1IECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType1IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType1IEC}>Save</button>
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

export default UpdateWindGenTurbineType1IECComponent
