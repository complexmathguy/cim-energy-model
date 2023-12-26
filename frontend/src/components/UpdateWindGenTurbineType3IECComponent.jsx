import React, { Component } from 'react'
import WindGenTurbineType3IECService from '../services/WindGenTurbineType3IECService';

class UpdateWindGenTurbineType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dipmax: '',
                diqmax: ''
        }
        this.updateWindGenTurbineType3IEC = this.updateWindGenTurbineType3IEC.bind(this);

        this.changedipmaxHandler = this.changedipmaxHandler.bind(this);
        this.changediqmaxHandler = this.changediqmaxHandler.bind(this);
    }

    componentDidMount(){
        WindGenTurbineType3IECService.getWindGenTurbineType3IECById(this.state.id).then( (res) =>{
            let windGenTurbineType3IEC = res.data;
            this.setState({
                dipmax: windGenTurbineType3IEC.dipmax,
                diqmax: windGenTurbineType3IEC.diqmax
            });
        });
    }

    updateWindGenTurbineType3IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3IEC = {
            windGenTurbineType3IECId: this.state.id,
            dipmax: this.state.dipmax,
            diqmax: this.state.diqmax
        };
        console.log('windGenTurbineType3IEC => ' + JSON.stringify(windGenTurbineType3IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType3IECService.updateWindGenTurbineType3IEC(windGenTurbineType3IEC).then( res => {
            this.props.history.push('/windGenTurbineType3IECs');
        });
    }

    changedipmaxHandler= (event) => {
        this.setState({dipmax: event.target.value});
    }
    changediqmaxHandler= (event) => {
        this.setState({diqmax: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGenTurbineType3IECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType3IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dipmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> diqmax: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType3IEC}>Save</button>
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

export default UpdateWindGenTurbineType3IECComponent
