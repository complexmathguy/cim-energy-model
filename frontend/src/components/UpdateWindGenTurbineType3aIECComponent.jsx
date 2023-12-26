import React, { Component } from 'react'
import WindGenTurbineType3aIECService from '../services/WindGenTurbineType3aIECService';

class UpdateWindGenTurbineType3aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kpc: '',
                tic: '',
                xs: ''
        }
        this.updateWindGenTurbineType3aIEC = this.updateWindGenTurbineType3aIEC.bind(this);

        this.changekpcHandler = this.changekpcHandler.bind(this);
        this.changeticHandler = this.changeticHandler.bind(this);
        this.changexsHandler = this.changexsHandler.bind(this);
    }

    componentDidMount(){
        WindGenTurbineType3aIECService.getWindGenTurbineType3aIECById(this.state.id).then( (res) =>{
            let windGenTurbineType3aIEC = res.data;
            this.setState({
                kpc: windGenTurbineType3aIEC.kpc,
                tic: windGenTurbineType3aIEC.tic,
                xs: windGenTurbineType3aIEC.xs
            });
        });
    }

    updateWindGenTurbineType3aIEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3aIEC = {
            windGenTurbineType3aIECId: this.state.id,
            kpc: this.state.kpc,
            tic: this.state.tic,
            xs: this.state.xs
        };
        console.log('windGenTurbineType3aIEC => ' + JSON.stringify(windGenTurbineType3aIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType3aIECService.updateWindGenTurbineType3aIEC(windGenTurbineType3aIEC).then( res => {
            this.props.history.push('/windGenTurbineType3aIECs');
        });
    }

    changekpcHandler= (event) => {
        this.setState({kpc: event.target.value});
    }
    changeticHandler= (event) => {
        this.setState({tic: event.target.value});
    }
    changexsHandler= (event) => {
        this.setState({xs: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGenTurbineType3aIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType3aIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kpc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tic: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xs: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType3aIEC}>Save</button>
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

export default UpdateWindGenTurbineType3aIECComponent
