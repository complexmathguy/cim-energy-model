import React, { Component } from 'react'
import ACLineSegmentService from '../services/ACLineSegmentService';

class UpdateACLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                b0ch: '',
                bch: '',
                g0ch: '',
                gch: '',
                r: '',
                r0: '',
                shortCircuitEndTemperature: '',
                x: '',
                x0: ''
        }
        this.updateACLineSegment = this.updateACLineSegment.bind(this);

        this.changeb0chHandler = this.changeb0chHandler.bind(this);
        this.changebchHandler = this.changebchHandler.bind(this);
        this.changeg0chHandler = this.changeg0chHandler.bind(this);
        this.changegchHandler = this.changegchHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changer0Handler = this.changer0Handler.bind(this);
        this.changeshortCircuitEndTemperatureHandler = this.changeshortCircuitEndTemperatureHandler.bind(this);
        this.changexHandler = this.changexHandler.bind(this);
        this.changex0Handler = this.changex0Handler.bind(this);
    }

    componentDidMount(){
        ACLineSegmentService.getACLineSegmentById(this.state.id).then( (res) =>{
            let aCLineSegment = res.data;
            this.setState({
                b0ch: aCLineSegment.b0ch,
                bch: aCLineSegment.bch,
                g0ch: aCLineSegment.g0ch,
                gch: aCLineSegment.gch,
                r: aCLineSegment.r,
                r0: aCLineSegment.r0,
                shortCircuitEndTemperature: aCLineSegment.shortCircuitEndTemperature,
                x: aCLineSegment.x,
                x0: aCLineSegment.x0
            });
        });
    }

    updateACLineSegment = (e) => {
        e.preventDefault();
        let aCLineSegment = {
            aCLineSegmentId: this.state.id,
            b0ch: this.state.b0ch,
            bch: this.state.bch,
            g0ch: this.state.g0ch,
            gch: this.state.gch,
            r: this.state.r,
            r0: this.state.r0,
            shortCircuitEndTemperature: this.state.shortCircuitEndTemperature,
            x: this.state.x,
            x0: this.state.x0
        };
        console.log('aCLineSegment => ' + JSON.stringify(aCLineSegment));
        console.log('id => ' + JSON.stringify(this.state.id));
        ACLineSegmentService.updateACLineSegment(aCLineSegment).then( res => {
            this.props.history.push('/aCLineSegments');
        });
    }

    changeb0chHandler= (event) => {
        this.setState({b0ch: event.target.value});
    }
    changebchHandler= (event) => {
        this.setState({bch: event.target.value});
    }
    changeg0chHandler= (event) => {
        this.setState({g0ch: event.target.value});
    }
    changegchHandler= (event) => {
        this.setState({gch: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changer0Handler= (event) => {
        this.setState({r0: event.target.value});
    }
    changeshortCircuitEndTemperatureHandler= (event) => {
        this.setState({shortCircuitEndTemperature: event.target.value});
    }
    changexHandler= (event) => {
        this.setState({x: event.target.value});
    }
    changex0Handler= (event) => {
        this.setState({x0: event.target.value});
    }

    cancel(){
        this.props.history.push('/aCLineSegments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ACLineSegment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> b0ch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> g0ch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> shortCircuitEndTemperature: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x0: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateACLineSegment}>Save</button>
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

export default UpdateACLineSegmentComponent
