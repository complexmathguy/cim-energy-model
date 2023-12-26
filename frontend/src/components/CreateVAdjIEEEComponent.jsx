import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService';

class CreateVAdjIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                adjslew: '',
                taoff: '',
                taon: '',
                vadjf: '',
                vadjmax: '',
                vadjmin: ''
        }
        this.changeadjslewHandler = this.changeadjslewHandler.bind(this);
        this.changetaoffHandler = this.changetaoffHandler.bind(this);
        this.changetaonHandler = this.changetaonHandler.bind(this);
        this.changevadjfHandler = this.changevadjfHandler.bind(this);
        this.changevadjmaxHandler = this.changevadjmaxHandler.bind(this);
        this.changevadjminHandler = this.changevadjminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VAdjIEEEService.getVAdjIEEEById(this.state.id).then( (res) =>{
                let vAdjIEEE = res.data;
                this.setState({
                    adjslew: vAdjIEEE.adjslew,
                    taoff: vAdjIEEE.taoff,
                    taon: vAdjIEEE.taon,
                    vadjf: vAdjIEEE.vadjf,
                    vadjmax: vAdjIEEE.vadjmax,
                    vadjmin: vAdjIEEE.vadjmin
                });
            });
        }        
    }
    saveOrUpdateVAdjIEEE = (e) => {
        e.preventDefault();
        let vAdjIEEE = {
                vAdjIEEEId: this.state.id,
                adjslew: this.state.adjslew,
                taoff: this.state.taoff,
                taon: this.state.taon,
                vadjf: this.state.vadjf,
                vadjmax: this.state.vadjmax,
                vadjmin: this.state.vadjmin
            };
        console.log('vAdjIEEE => ' + JSON.stringify(vAdjIEEE));

        // step 5
        if(this.state.id === '_add'){
            vAdjIEEE.vAdjIEEEId=''
            VAdjIEEEService.createVAdjIEEE(vAdjIEEE).then(res =>{
                this.props.history.push('/vAdjIEEEs');
            });
        }else{
            VAdjIEEEService.updateVAdjIEEE(vAdjIEEE).then( res => {
                this.props.history.push('/vAdjIEEEs');
            });
        }
    }
    
    changeadjslewHandler= (event) => {
        this.setState({adjslew: event.target.value});
    }
    changetaoffHandler= (event) => {
        this.setState({taoff: event.target.value});
    }
    changetaonHandler= (event) => {
        this.setState({taon: event.target.value});
    }
    changevadjfHandler= (event) => {
        this.setState({vadjf: event.target.value});
    }
    changevadjmaxHandler= (event) => {
        this.setState({vadjmax: event.target.value});
    }
    changevadjminHandler= (event) => {
        this.setState({vadjmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/vAdjIEEEs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VAdjIEEE</h3>
        }else{
            return <h3 className="text-center">Update VAdjIEEE</h3>
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
                                            <label> adjslew: </label>
                                            #formFields( $attribute, 'create')
                                            <label> taoff: </label>
                                            #formFields( $attribute, 'create')
                                            <label> taon: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vadjf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vadjmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vadjmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVAdjIEEE}>Save</button>
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

export default CreateVAdjIEEEComponent
