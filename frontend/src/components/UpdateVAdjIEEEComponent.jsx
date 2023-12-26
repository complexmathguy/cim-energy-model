import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService';

class UpdateVAdjIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                adjslew: '',
                taoff: '',
                taon: '',
                vadjf: '',
                vadjmax: '',
                vadjmin: ''
        }
        this.updateVAdjIEEE = this.updateVAdjIEEE.bind(this);

        this.changeadjslewHandler = this.changeadjslewHandler.bind(this);
        this.changetaoffHandler = this.changetaoffHandler.bind(this);
        this.changetaonHandler = this.changetaonHandler.bind(this);
        this.changevadjfHandler = this.changevadjfHandler.bind(this);
        this.changevadjmaxHandler = this.changevadjmaxHandler.bind(this);
        this.changevadjminHandler = this.changevadjminHandler.bind(this);
    }

    componentDidMount(){
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

    updateVAdjIEEE = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        VAdjIEEEService.updateVAdjIEEE(vAdjIEEE).then( res => {
            this.props.history.push('/vAdjIEEEs');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VAdjIEEE</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> adjslew: </label>
                                            #formFields( $attribute, 'update')
                                            <label> taoff: </label>
                                            #formFields( $attribute, 'update')
                                            <label> taon: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vadjf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vadjmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vadjmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVAdjIEEE}>Save</button>
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

export default UpdateVAdjIEEEComponent
