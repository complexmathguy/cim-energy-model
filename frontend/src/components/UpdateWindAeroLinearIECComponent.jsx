import React, { Component } from 'react'
import WindAeroLinearIECService from '../services/WindAeroLinearIECService';

class UpdateWindAeroLinearIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dpomega: '',
                dptheta: '',
                omegazero: '',
                pavail: '',
                thetazero: ''
        }
        this.updateWindAeroLinearIEC = this.updateWindAeroLinearIEC.bind(this);

        this.changedpomegaHandler = this.changedpomegaHandler.bind(this);
        this.changedpthetaHandler = this.changedpthetaHandler.bind(this);
        this.changeomegazeroHandler = this.changeomegazeroHandler.bind(this);
        this.changepavailHandler = this.changepavailHandler.bind(this);
        this.changethetazeroHandler = this.changethetazeroHandler.bind(this);
    }

    componentDidMount(){
        WindAeroLinearIECService.getWindAeroLinearIECById(this.state.id).then( (res) =>{
            let windAeroLinearIEC = res.data;
            this.setState({
                dpomega: windAeroLinearIEC.dpomega,
                dptheta: windAeroLinearIEC.dptheta,
                omegazero: windAeroLinearIEC.omegazero,
                pavail: windAeroLinearIEC.pavail,
                thetazero: windAeroLinearIEC.thetazero
            });
        });
    }

    updateWindAeroLinearIEC = (e) => {
        e.preventDefault();
        let windAeroLinearIEC = {
            windAeroLinearIECId: this.state.id,
            dpomega: this.state.dpomega,
            dptheta: this.state.dptheta,
            omegazero: this.state.omegazero,
            pavail: this.state.pavail,
            thetazero: this.state.thetazero
        };
        console.log('windAeroLinearIEC => ' + JSON.stringify(windAeroLinearIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindAeroLinearIECService.updateWindAeroLinearIEC(windAeroLinearIEC).then( res => {
            this.props.history.push('/windAeroLinearIECs');
        });
    }

    changedpomegaHandler= (event) => {
        this.setState({dpomega: event.target.value});
    }
    changedpthetaHandler= (event) => {
        this.setState({dptheta: event.target.value});
    }
    changeomegazeroHandler= (event) => {
        this.setState({omegazero: event.target.value});
    }
    changepavailHandler= (event) => {
        this.setState({pavail: event.target.value});
    }
    changethetazeroHandler= (event) => {
        this.setState({thetazero: event.target.value});
    }

    cancel(){
        this.props.history.push('/windAeroLinearIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindAeroLinearIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dpomega: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dptheta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> omegazero: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pavail: </label>
                                            #formFields( $attribute, 'update')
                                            <label> thetazero: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindAeroLinearIEC}>Save</button>
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

export default UpdateWindAeroLinearIECComponent
