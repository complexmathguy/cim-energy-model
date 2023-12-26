import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService';

class UpdateNonlinearShuntCompensatorPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                b: '',
                b0: '',
                g: '',
                g0: '',
                sectionNumber: ''
        }
        this.updateNonlinearShuntCompensatorPoint = this.updateNonlinearShuntCompensatorPoint.bind(this);

        this.changebHandler = this.changebHandler.bind(this);
        this.changeb0Handler = this.changeb0Handler.bind(this);
        this.changegHandler = this.changegHandler.bind(this);
        this.changeg0Handler = this.changeg0Handler.bind(this);
        this.changesectionNumberHandler = this.changesectionNumberHandler.bind(this);
    }

    componentDidMount(){
        NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPointById(this.state.id).then( (res) =>{
            let nonlinearShuntCompensatorPoint = res.data;
            this.setState({
                b: nonlinearShuntCompensatorPoint.b,
                b0: nonlinearShuntCompensatorPoint.b0,
                g: nonlinearShuntCompensatorPoint.g,
                g0: nonlinearShuntCompensatorPoint.g0,
                sectionNumber: nonlinearShuntCompensatorPoint.sectionNumber
            });
        });
    }

    updateNonlinearShuntCompensatorPoint = (e) => {
        e.preventDefault();
        let nonlinearShuntCompensatorPoint = {
            nonlinearShuntCompensatorPointId: this.state.id,
            b: this.state.b,
            b0: this.state.b0,
            g: this.state.g,
            g0: this.state.g0,
            sectionNumber: this.state.sectionNumber
        };
        console.log('nonlinearShuntCompensatorPoint => ' + JSON.stringify(nonlinearShuntCompensatorPoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        NonlinearShuntCompensatorPointService.updateNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint).then( res => {
            this.props.history.push('/nonlinearShuntCompensatorPoints');
        });
    }

    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changeb0Handler= (event) => {
        this.setState({b0: event.target.value});
    }
    changegHandler= (event) => {
        this.setState({g: event.target.value});
    }
    changeg0Handler= (event) => {
        this.setState({g0: event.target.value});
    }
    changesectionNumberHandler= (event) => {
        this.setState({sectionNumber: event.target.value});
    }

    cancel(){
        this.props.history.push('/nonlinearShuntCompensatorPoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NonlinearShuntCompensatorPoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b: </label>
                                            #formFields( $attribute, 'update')
                                            <label> b0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> sectionNumber: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNonlinearShuntCompensatorPoint}>Save</button>
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

export default UpdateNonlinearShuntCompensatorPointComponent
