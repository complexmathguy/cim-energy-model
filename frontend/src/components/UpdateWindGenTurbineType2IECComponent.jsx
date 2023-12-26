import React, { Component } from 'react'
import WindGenTurbineType2IECService from '../services/WindGenTurbineType2IECService';

class UpdateWindGenTurbineType2IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindGenTurbineType2IEC = this.updateWindGenTurbineType2IEC.bind(this);

    }

    componentDidMount(){
        WindGenTurbineType2IECService.getWindGenTurbineType2IECById(this.state.id).then( (res) =>{
            let windGenTurbineType2IEC = res.data;
            this.setState({
            });
        });
    }

    updateWindGenTurbineType2IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType2IEC = {
            windGenTurbineType2IECId: this.state.id,
        };
        console.log('windGenTurbineType2IEC => ' + JSON.stringify(windGenTurbineType2IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType2IECService.updateWindGenTurbineType2IEC(windGenTurbineType2IEC).then( res => {
            this.props.history.push('/windGenTurbineType2IECs');
        });
    }


    cancel(){
        this.props.history.push('/windGenTurbineType2IECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType2IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType2IEC}>Save</button>
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

export default UpdateWindGenTurbineType2IECComponent
