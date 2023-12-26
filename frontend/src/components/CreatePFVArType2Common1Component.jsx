import React, { Component } from 'react'
import PFVArType2Common1Service from '../services/PFVArType2Common1Service';

class CreatePFVArType2Common1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                j: '',
                ki: '',
                kp: '',
                max: '',
                ref: ''
        }
        this.changejHandler = this.changejHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemaxHandler = this.changemaxHandler.bind(this);
        this.changerefHandler = this.changerefHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PFVArType2Common1Service.getPFVArType2Common1ById(this.state.id).then( (res) =>{
                let pFVArType2Common1 = res.data;
                this.setState({
                    j: pFVArType2Common1.j,
                    ki: pFVArType2Common1.ki,
                    kp: pFVArType2Common1.kp,
                    max: pFVArType2Common1.max,
                    ref: pFVArType2Common1.ref
                });
            });
        }        
    }
    saveOrUpdatePFVArType2Common1 = (e) => {
        e.preventDefault();
        let pFVArType2Common1 = {
                pFVArType2Common1Id: this.state.id,
                j: this.state.j,
                ki: this.state.ki,
                kp: this.state.kp,
                max: this.state.max,
                ref: this.state.ref
            };
        console.log('pFVArType2Common1 => ' + JSON.stringify(pFVArType2Common1));

        // step 5
        if(this.state.id === '_add'){
            pFVArType2Common1.pFVArType2Common1Id=''
            PFVArType2Common1Service.createPFVArType2Common1(pFVArType2Common1).then(res =>{
                this.props.history.push('/pFVArType2Common1s');
            });
        }else{
            PFVArType2Common1Service.updatePFVArType2Common1(pFVArType2Common1).then( res => {
                this.props.history.push('/pFVArType2Common1s');
            });
        }
    }
    
    changejHandler= (event) => {
        this.setState({j: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changemaxHandler= (event) => {
        this.setState({max: event.target.value});
    }
    changerefHandler= (event) => {
        this.setState({ref: event.target.value});
    }

    cancel(){
        this.props.history.push('/pFVArType2Common1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType2Common1</h3>
        }else{
            return <h3 className="text-center">Update PFVArType2Common1</h3>
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
                                            <label> j: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> max: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ref: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType2Common1}>Save</button>
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

export default CreatePFVArType2Common1Component
