import React, { Component } from 'react'
import SvVoltageService from '../services/SvVoltageService';

class UpdateSvVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                angle: '',
                v: ''
        }
        this.updateSvVoltage = this.updateSvVoltage.bind(this);

        this.changeangleHandler = this.changeangleHandler.bind(this);
        this.changevHandler = this.changevHandler.bind(this);
    }

    componentDidMount(){
        SvVoltageService.getSvVoltageById(this.state.id).then( (res) =>{
            let svVoltage = res.data;
            this.setState({
                angle: svVoltage.angle,
                v: svVoltage.v
            });
        });
    }

    updateSvVoltage = (e) => {
        e.preventDefault();
        let svVoltage = {
            svVoltageId: this.state.id,
            angle: this.state.angle,
            v: this.state.v
        };
        console.log('svVoltage => ' + JSON.stringify(svVoltage));
        console.log('id => ' + JSON.stringify(this.state.id));
        SvVoltageService.updateSvVoltage(svVoltage).then( res => {
            this.props.history.push('/svVoltages');
        });
    }

    changeangleHandler= (event) => {
        this.setState({angle: event.target.value});
    }
    changevHandler= (event) => {
        this.setState({v: event.target.value});
    }

    cancel(){
        this.props.history.push('/svVoltages');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SvVoltage</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> angle: </label>
                                            #formFields( $attribute, 'update')
                                            <label> v: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSvVoltage}>Save</button>
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

export default UpdateSvVoltageComponent
