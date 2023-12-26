import React, { Component } from 'react'
import WindPlantIECService from '../services/WindPlantIECService';

class UpdateWindPlantIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindPlantIEC = this.updateWindPlantIEC.bind(this);

    }

    componentDidMount(){
        WindPlantIECService.getWindPlantIECById(this.state.id).then( (res) =>{
            let windPlantIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindPlantIEC = (e) => {
        e.preventDefault();
        let windPlantIEC = {
            windPlantIECId: this.state.id,
        };
        console.log('windPlantIEC => ' + JSON.stringify(windPlantIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantIECService.updateWindPlantIEC(windPlantIEC).then( res => {
            this.props.history.push('/windPlantIECs');
        });
    }


    cancel(){
        this.props.history.push('/windPlantIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantIEC}>Save</button>
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

export default UpdateWindPlantIECComponent
