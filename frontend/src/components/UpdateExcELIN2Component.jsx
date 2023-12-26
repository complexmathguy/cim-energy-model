import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service';

class UpdateExcELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdbas: '',
                iefmax: '',
                iefmax2: '',
                iefmin: '',
                k1: '',
                k1ec: '',
                k2: '',
                k3: '',
                k4: '',
                kd1: '',
                ke2: '',
                ketb: '',
                pid1max: '',
                seve1: '',
                seve2: '',
                tb1: '',
                te: '',
                te2: '',
                ti1: '',
                ti3: '',
                ti4: '',
                tr4: '',
                upmax: '',
                upmin: '',
                ve1: '',
                ve2: '',
                xp: ''
        }
        this.updateExcELIN2 = this.updateExcELIN2.bind(this);

        this.changeefdbasHandler = this.changeefdbasHandler.bind(this);
        this.changeiefmaxHandler = this.changeiefmaxHandler.bind(this);
        this.changeiefmax2Handler = this.changeiefmax2Handler.bind(this);
        this.changeiefminHandler = this.changeiefminHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek1ecHandler = this.changek1ecHandler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changek4Handler = this.changek4Handler.bind(this);
        this.changekd1Handler = this.changekd1Handler.bind(this);
        this.changeke2Handler = this.changeke2Handler.bind(this);
        this.changeketbHandler = this.changeketbHandler.bind(this);
        this.changepid1maxHandler = this.changepid1maxHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetb1Handler = this.changetb1Handler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changete2Handler = this.changete2Handler.bind(this);
        this.changeti1Handler = this.changeti1Handler.bind(this);
        this.changeti3Handler = this.changeti3Handler.bind(this);
        this.changeti4Handler = this.changeti4Handler.bind(this);
        this.changetr4Handler = this.changetr4Handler.bind(this);
        this.changeupmaxHandler = this.changeupmaxHandler.bind(this);
        this.changeupminHandler = this.changeupminHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changexpHandler = this.changexpHandler.bind(this);
    }

    componentDidMount(){
        ExcELIN2Service.getExcELIN2ById(this.state.id).then( (res) =>{
            let excELIN2 = res.data;
            this.setState({
                efdbas: excELIN2.efdbas,
                iefmax: excELIN2.iefmax,
                iefmax2: excELIN2.iefmax2,
                iefmin: excELIN2.iefmin,
                k1: excELIN2.k1,
                k1ec: excELIN2.k1ec,
                k2: excELIN2.k2,
                k3: excELIN2.k3,
                k4: excELIN2.k4,
                kd1: excELIN2.kd1,
                ke2: excELIN2.ke2,
                ketb: excELIN2.ketb,
                pid1max: excELIN2.pid1max,
                seve1: excELIN2.seve1,
                seve2: excELIN2.seve2,
                tb1: excELIN2.tb1,
                te: excELIN2.te,
                te2: excELIN2.te2,
                ti1: excELIN2.ti1,
                ti3: excELIN2.ti3,
                ti4: excELIN2.ti4,
                tr4: excELIN2.tr4,
                upmax: excELIN2.upmax,
                upmin: excELIN2.upmin,
                ve1: excELIN2.ve1,
                ve2: excELIN2.ve2,
                xp: excELIN2.xp
            });
        });
    }

    updateExcELIN2 = (e) => {
        e.preventDefault();
        let excELIN2 = {
            excELIN2Id: this.state.id,
            efdbas: this.state.efdbas,
            iefmax: this.state.iefmax,
            iefmax2: this.state.iefmax2,
            iefmin: this.state.iefmin,
            k1: this.state.k1,
            k1ec: this.state.k1ec,
            k2: this.state.k2,
            k3: this.state.k3,
            k4: this.state.k4,
            kd1: this.state.kd1,
            ke2: this.state.ke2,
            ketb: this.state.ketb,
            pid1max: this.state.pid1max,
            seve1: this.state.seve1,
            seve2: this.state.seve2,
            tb1: this.state.tb1,
            te: this.state.te,
            te2: this.state.te2,
            ti1: this.state.ti1,
            ti3: this.state.ti3,
            ti4: this.state.ti4,
            tr4: this.state.tr4,
            upmax: this.state.upmax,
            upmin: this.state.upmin,
            ve1: this.state.ve1,
            ve2: this.state.ve2,
            xp: this.state.xp
        };
        console.log('excELIN2 => ' + JSON.stringify(excELIN2));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcELIN2Service.updateExcELIN2(excELIN2).then( res => {
            this.props.history.push('/excELIN2s');
        });
    }

    changeefdbasHandler= (event) => {
        this.setState({efdbas: event.target.value});
    }
    changeiefmaxHandler= (event) => {
        this.setState({iefmax: event.target.value});
    }
    changeiefmax2Handler= (event) => {
        this.setState({iefmax2: event.target.value});
    }
    changeiefminHandler= (event) => {
        this.setState({iefmin: event.target.value});
    }
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek1ecHandler= (event) => {
        this.setState({k1ec: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changek3Handler= (event) => {
        this.setState({k3: event.target.value});
    }
    changek4Handler= (event) => {
        this.setState({k4: event.target.value});
    }
    changekd1Handler= (event) => {
        this.setState({kd1: event.target.value});
    }
    changeke2Handler= (event) => {
        this.setState({ke2: event.target.value});
    }
    changeketbHandler= (event) => {
        this.setState({ketb: event.target.value});
    }
    changepid1maxHandler= (event) => {
        this.setState({pid1max: event.target.value});
    }
    changeseve1Handler= (event) => {
        this.setState({seve1: event.target.value});
    }
    changeseve2Handler= (event) => {
        this.setState({seve2: event.target.value});
    }
    changetb1Handler= (event) => {
        this.setState({tb1: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changete2Handler= (event) => {
        this.setState({te2: event.target.value});
    }
    changeti1Handler= (event) => {
        this.setState({ti1: event.target.value});
    }
    changeti3Handler= (event) => {
        this.setState({ti3: event.target.value});
    }
    changeti4Handler= (event) => {
        this.setState({ti4: event.target.value});
    }
    changetr4Handler= (event) => {
        this.setState({tr4: event.target.value});
    }
    changeupmaxHandler= (event) => {
        this.setState({upmax: event.target.value});
    }
    changeupminHandler= (event) => {
        this.setState({upmin: event.target.value});
    }
    changeve1Handler= (event) => {
        this.setState({ve1: event.target.value});
    }
    changeve2Handler= (event) => {
        this.setState({ve2: event.target.value});
    }
    changexpHandler= (event) => {
        this.setState({xp: event.target.value});
    }

    cancel(){
        this.props.history.push('/excELIN2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcELIN2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdbas: </label>
                                            #formFields( $attribute, 'update')
                                            <label> iefmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> iefmax2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> iefmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1ec: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ketb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pid1max: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ti1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ti3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ti4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> upmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> upmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xp: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcELIN2}>Save</button>
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

export default UpdateExcELIN2Component
