import React, { Component } from 'react'
import DCGroundService from '../services/DCGroundService';

class UpdateDCGroundComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inductance: '',
                r: ''
        }
        this.updateDCGround = this.updateDCGround.bind(this);

        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
    }

    componentDidMount(){
        DCGroundService.getDCGroundById(this.state.id).then( (res) =>{
            let dCGround = res.data;
            this.setState({
                inductance: dCGround.inductance,
                r: dCGround.r
            });
        });
    }

    updateDCGround = (e) => {
        e.preventDefault();
        let dCGround = {
            dCGroundId: this.state.id,
            inductance: this.state.inductance,
            r: this.state.r
        };
        console.log('dCGround => ' + JSON.stringify(dCGround));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCGroundService.updateDCGround(dCGround).then( res => {
            this.props.history.push('/dCGrounds');
        });
    }

    changeinductanceHandler= (event) => {
        this.setState({inductance: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCGrounds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCGround</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCGround}>Save</button>
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

export default UpdateDCGroundComponent
