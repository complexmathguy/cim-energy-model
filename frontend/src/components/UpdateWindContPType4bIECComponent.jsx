import React, { Component } from 'react'
import WindContPType4bIECService from '../services/WindContPType4bIECService';

class UpdateWindContPType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dpmax: '',
                tpaero: '',
                tpord: '',
                tufilt: ''
        }
        this.updateWindContPType4bIEC = this.updateWindContPType4bIEC.bind(this);

        this.changedpmaxHandler = this.changedpmaxHandler.bind(this);
        this.changetpaeroHandler = this.changetpaeroHandler.bind(this);
        this.changetpordHandler = this.changetpordHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
    }

    componentDidMount(){
        WindContPType4bIECService.getWindContPType4bIECById(this.state.id).then( (res) =>{
            let windContPType4bIEC = res.data;
            this.setState({
                dpmax: windContPType4bIEC.dpmax,
                tpaero: windContPType4bIEC.tpaero,
                tpord: windContPType4bIEC.tpord,
                tufilt: windContPType4bIEC.tufilt
            });
        });
    }

    updateWindContPType4bIEC = (e) => {
        e.preventDefault();
        let windContPType4bIEC = {
            windContPType4bIECId: this.state.id,
            dpmax: this.state.dpmax,
            tpaero: this.state.tpaero,
            tpord: this.state.tpord,
            tufilt: this.state.tufilt
        };
        console.log('windContPType4bIEC => ' + JSON.stringify(windContPType4bIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContPType4bIECService.updateWindContPType4bIEC(windContPType4bIEC).then( res => {
            this.props.history.push('/windContPType4bIECs');
        });
    }

    changedpmaxHandler= (event) => {
        this.setState({dpmax: event.target.value});
    }
    changetpaeroHandler= (event) => {
        this.setState({tpaero: event.target.value});
    }
    changetpordHandler= (event) => {
        this.setState({tpord: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContPType4bIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContPType4bIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dpmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpaero: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpord: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContPType4bIEC}>Save</button>
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

export default UpdateWindContPType4bIECComponent
