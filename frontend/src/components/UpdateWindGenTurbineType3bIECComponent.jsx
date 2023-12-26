import React, { Component } from 'react'
import WindGenTurbineType3bIECService from '../services/WindGenTurbineType3bIECService';

class UpdateWindGenTurbineType3bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                fducw: '',
                mwtcwp: '',
                tg: '',
                two: '',
                xs: ''
        }
        this.updateWindGenTurbineType3bIEC = this.updateWindGenTurbineType3bIEC.bind(this);

        this.changefducwHandler = this.changefducwHandler.bind(this);
        this.changemwtcwpHandler = this.changemwtcwpHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetwoHandler = this.changetwoHandler.bind(this);
        this.changexsHandler = this.changexsHandler.bind(this);
    }

    componentDidMount(){
        WindGenTurbineType3bIECService.getWindGenTurbineType3bIECById(this.state.id).then( (res) =>{
            let windGenTurbineType3bIEC = res.data;
            this.setState({
                fducw: windGenTurbineType3bIEC.fducw,
                mwtcwp: windGenTurbineType3bIEC.mwtcwp,
                tg: windGenTurbineType3bIEC.tg,
                two: windGenTurbineType3bIEC.two,
                xs: windGenTurbineType3bIEC.xs
            });
        });
    }

    updateWindGenTurbineType3bIEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3bIEC = {
            windGenTurbineType3bIECId: this.state.id,
            fducw: this.state.fducw,
            mwtcwp: this.state.mwtcwp,
            tg: this.state.tg,
            two: this.state.two,
            xs: this.state.xs
        };
        console.log('windGenTurbineType3bIEC => ' + JSON.stringify(windGenTurbineType3bIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType3bIECService.updateWindGenTurbineType3bIEC(windGenTurbineType3bIEC).then( res => {
            this.props.history.push('/windGenTurbineType3bIECs');
        });
    }

    changefducwHandler= (event) => {
        this.setState({fducw: event.target.value});
    }
    changemwtcwpHandler= (event) => {
        this.setState({mwtcwp: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetwoHandler= (event) => {
        this.setState({two: event.target.value});
    }
    changexsHandler= (event) => {
        this.setState({xs: event.target.value});
    }

    cancel(){
        this.props.history.push('/windGenTurbineType3bIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType3bIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> fducw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwtcwp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> two: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xs: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType3bIEC}>Save</button>
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

export default UpdateWindGenTurbineType3bIECComponent
