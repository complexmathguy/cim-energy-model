import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service';

class CreateUnderexcLimIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                k1: '',
                k2: '',
                kfb: '',
                kuf: '',
                kui: '',
                kul: '',
                p0: '',
                p1: '',
                p10: '',
                p2: '',
                p3: '',
                p4: '',
                p5: '',
                p6: '',
                p7: '',
                p8: '',
                p9: '',
                q0: '',
                q1: '',
                q10: '',
                q2: '',
                q3: '',
                q4: '',
                q5: '',
                q6: '',
                q7: '',
                q8: '',
                q9: '',
                tu1: '',
                tu2: '',
                tu3: '',
                tu4: '',
                tul: '',
                tup: '',
                tuq: '',
                tuv: '',
                vuimax: '',
                vuimin: '',
                vulmax: '',
                vulmin: ''
        }
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changekfbHandler = this.changekfbHandler.bind(this);
        this.changekufHandler = this.changekufHandler.bind(this);
        this.changekuiHandler = this.changekuiHandler.bind(this);
        this.changekulHandler = this.changekulHandler.bind(this);
        this.changep0Handler = this.changep0Handler.bind(this);
        this.changep1Handler = this.changep1Handler.bind(this);
        this.changep10Handler = this.changep10Handler.bind(this);
        this.changep2Handler = this.changep2Handler.bind(this);
        this.changep3Handler = this.changep3Handler.bind(this);
        this.changep4Handler = this.changep4Handler.bind(this);
        this.changep5Handler = this.changep5Handler.bind(this);
        this.changep6Handler = this.changep6Handler.bind(this);
        this.changep7Handler = this.changep7Handler.bind(this);
        this.changep8Handler = this.changep8Handler.bind(this);
        this.changep9Handler = this.changep9Handler.bind(this);
        this.changeq0Handler = this.changeq0Handler.bind(this);
        this.changeq1Handler = this.changeq1Handler.bind(this);
        this.changeq10Handler = this.changeq10Handler.bind(this);
        this.changeq2Handler = this.changeq2Handler.bind(this);
        this.changeq3Handler = this.changeq3Handler.bind(this);
        this.changeq4Handler = this.changeq4Handler.bind(this);
        this.changeq5Handler = this.changeq5Handler.bind(this);
        this.changeq6Handler = this.changeq6Handler.bind(this);
        this.changeq7Handler = this.changeq7Handler.bind(this);
        this.changeq8Handler = this.changeq8Handler.bind(this);
        this.changeq9Handler = this.changeq9Handler.bind(this);
        this.changetu1Handler = this.changetu1Handler.bind(this);
        this.changetu2Handler = this.changetu2Handler.bind(this);
        this.changetu3Handler = this.changetu3Handler.bind(this);
        this.changetu4Handler = this.changetu4Handler.bind(this);
        this.changetulHandler = this.changetulHandler.bind(this);
        this.changetupHandler = this.changetupHandler.bind(this);
        this.changetuqHandler = this.changetuqHandler.bind(this);
        this.changetuvHandler = this.changetuvHandler.bind(this);
        this.changevuimaxHandler = this.changevuimaxHandler.bind(this);
        this.changevuiminHandler = this.changevuiminHandler.bind(this);
        this.changevulmaxHandler = this.changevulmaxHandler.bind(this);
        this.changevulminHandler = this.changevulminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            UnderexcLimIEEE2Service.getUnderexcLimIEEE2ById(this.state.id).then( (res) =>{
                let underexcLimIEEE2 = res.data;
                this.setState({
                    k1: underexcLimIEEE2.k1,
                    k2: underexcLimIEEE2.k2,
                    kfb: underexcLimIEEE2.kfb,
                    kuf: underexcLimIEEE2.kuf,
                    kui: underexcLimIEEE2.kui,
                    kul: underexcLimIEEE2.kul,
                    p0: underexcLimIEEE2.p0,
                    p1: underexcLimIEEE2.p1,
                    p10: underexcLimIEEE2.p10,
                    p2: underexcLimIEEE2.p2,
                    p3: underexcLimIEEE2.p3,
                    p4: underexcLimIEEE2.p4,
                    p5: underexcLimIEEE2.p5,
                    p6: underexcLimIEEE2.p6,
                    p7: underexcLimIEEE2.p7,
                    p8: underexcLimIEEE2.p8,
                    p9: underexcLimIEEE2.p9,
                    q0: underexcLimIEEE2.q0,
                    q1: underexcLimIEEE2.q1,
                    q10: underexcLimIEEE2.q10,
                    q2: underexcLimIEEE2.q2,
                    q3: underexcLimIEEE2.q3,
                    q4: underexcLimIEEE2.q4,
                    q5: underexcLimIEEE2.q5,
                    q6: underexcLimIEEE2.q6,
                    q7: underexcLimIEEE2.q7,
                    q8: underexcLimIEEE2.q8,
                    q9: underexcLimIEEE2.q9,
                    tu1: underexcLimIEEE2.tu1,
                    tu2: underexcLimIEEE2.tu2,
                    tu3: underexcLimIEEE2.tu3,
                    tu4: underexcLimIEEE2.tu4,
                    tul: underexcLimIEEE2.tul,
                    tup: underexcLimIEEE2.tup,
                    tuq: underexcLimIEEE2.tuq,
                    tuv: underexcLimIEEE2.tuv,
                    vuimax: underexcLimIEEE2.vuimax,
                    vuimin: underexcLimIEEE2.vuimin,
                    vulmax: underexcLimIEEE2.vulmax,
                    vulmin: underexcLimIEEE2.vulmin
                });
            });
        }        
    }
    saveOrUpdateUnderexcLimIEEE2 = (e) => {
        e.preventDefault();
        let underexcLimIEEE2 = {
                underexcLimIEEE2Id: this.state.id,
                k1: this.state.k1,
                k2: this.state.k2,
                kfb: this.state.kfb,
                kuf: this.state.kuf,
                kui: this.state.kui,
                kul: this.state.kul,
                p0: this.state.p0,
                p1: this.state.p1,
                p10: this.state.p10,
                p2: this.state.p2,
                p3: this.state.p3,
                p4: this.state.p4,
                p5: this.state.p5,
                p6: this.state.p6,
                p7: this.state.p7,
                p8: this.state.p8,
                p9: this.state.p9,
                q0: this.state.q0,
                q1: this.state.q1,
                q10: this.state.q10,
                q2: this.state.q2,
                q3: this.state.q3,
                q4: this.state.q4,
                q5: this.state.q5,
                q6: this.state.q6,
                q7: this.state.q7,
                q8: this.state.q8,
                q9: this.state.q9,
                tu1: this.state.tu1,
                tu2: this.state.tu2,
                tu3: this.state.tu3,
                tu4: this.state.tu4,
                tul: this.state.tul,
                tup: this.state.tup,
                tuq: this.state.tuq,
                tuv: this.state.tuv,
                vuimax: this.state.vuimax,
                vuimin: this.state.vuimin,
                vulmax: this.state.vulmax,
                vulmin: this.state.vulmin
            };
        console.log('underexcLimIEEE2 => ' + JSON.stringify(underexcLimIEEE2));

        // step 5
        if(this.state.id === '_add'){
            underexcLimIEEE2.underexcLimIEEE2Id=''
            UnderexcLimIEEE2Service.createUnderexcLimIEEE2(underexcLimIEEE2).then(res =>{
                this.props.history.push('/underexcLimIEEE2s');
            });
        }else{
            UnderexcLimIEEE2Service.updateUnderexcLimIEEE2(underexcLimIEEE2).then( res => {
                this.props.history.push('/underexcLimIEEE2s');
            });
        }
    }
    
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changekfbHandler= (event) => {
        this.setState({kfb: event.target.value});
    }
    changekufHandler= (event) => {
        this.setState({kuf: event.target.value});
    }
    changekuiHandler= (event) => {
        this.setState({kui: event.target.value});
    }
    changekulHandler= (event) => {
        this.setState({kul: event.target.value});
    }
    changep0Handler= (event) => {
        this.setState({p0: event.target.value});
    }
    changep1Handler= (event) => {
        this.setState({p1: event.target.value});
    }
    changep10Handler= (event) => {
        this.setState({p10: event.target.value});
    }
    changep2Handler= (event) => {
        this.setState({p2: event.target.value});
    }
    changep3Handler= (event) => {
        this.setState({p3: event.target.value});
    }
    changep4Handler= (event) => {
        this.setState({p4: event.target.value});
    }
    changep5Handler= (event) => {
        this.setState({p5: event.target.value});
    }
    changep6Handler= (event) => {
        this.setState({p6: event.target.value});
    }
    changep7Handler= (event) => {
        this.setState({p7: event.target.value});
    }
    changep8Handler= (event) => {
        this.setState({p8: event.target.value});
    }
    changep9Handler= (event) => {
        this.setState({p9: event.target.value});
    }
    changeq0Handler= (event) => {
        this.setState({q0: event.target.value});
    }
    changeq1Handler= (event) => {
        this.setState({q1: event.target.value});
    }
    changeq10Handler= (event) => {
        this.setState({q10: event.target.value});
    }
    changeq2Handler= (event) => {
        this.setState({q2: event.target.value});
    }
    changeq3Handler= (event) => {
        this.setState({q3: event.target.value});
    }
    changeq4Handler= (event) => {
        this.setState({q4: event.target.value});
    }
    changeq5Handler= (event) => {
        this.setState({q5: event.target.value});
    }
    changeq6Handler= (event) => {
        this.setState({q6: event.target.value});
    }
    changeq7Handler= (event) => {
        this.setState({q7: event.target.value});
    }
    changeq8Handler= (event) => {
        this.setState({q8: event.target.value});
    }
    changeq9Handler= (event) => {
        this.setState({q9: event.target.value});
    }
    changetu1Handler= (event) => {
        this.setState({tu1: event.target.value});
    }
    changetu2Handler= (event) => {
        this.setState({tu2: event.target.value});
    }
    changetu3Handler= (event) => {
        this.setState({tu3: event.target.value});
    }
    changetu4Handler= (event) => {
        this.setState({tu4: event.target.value});
    }
    changetulHandler= (event) => {
        this.setState({tul: event.target.value});
    }
    changetupHandler= (event) => {
        this.setState({tup: event.target.value});
    }
    changetuqHandler= (event) => {
        this.setState({tuq: event.target.value});
    }
    changetuvHandler= (event) => {
        this.setState({tuv: event.target.value});
    }
    changevuimaxHandler= (event) => {
        this.setState({vuimax: event.target.value});
    }
    changevuiminHandler= (event) => {
        this.setState({vuimin: event.target.value});
    }
    changevulmaxHandler= (event) => {
        this.setState({vulmax: event.target.value});
    }
    changevulminHandler= (event) => {
        this.setState({vulmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/underexcLimIEEE2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add UnderexcLimIEEE2</h3>
        }else{
            return <h3 className="text-center">Update UnderexcLimIEEE2</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> k1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kfb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kuf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kui: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kul: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> p9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> q9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tu4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tul: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tup: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuq: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuv: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vuimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vuimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vulmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vulmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateUnderexcLimIEEE2}>Save</button>
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

export default CreateUnderexcLimIEEE2Component
