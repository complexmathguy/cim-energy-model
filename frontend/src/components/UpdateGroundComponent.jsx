import React, { Component } from 'react'
import GroundService from '../services/GroundService';

class UpdateGroundComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGround = this.updateGround.bind(this);

    }

    componentDidMount(){
        GroundService.getGroundById(this.state.id).then( (res) =>{
            let ground = res.data;
            this.setState({
            });
        });
    }

    updateGround = (e) => {
        e.preventDefault();
        let ground = {
            groundId: this.state.id,
        };
        console.log('ground => ' + JSON.stringify(ground));
        console.log('id => ' + JSON.stringify(this.state.id));
        GroundService.updateGround(ground).then( res => {
            this.props.history.push('/grounds');
        });
    }


    cancel(){
        this.props.history.push('/grounds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Ground</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGround}>Save</button>
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

export default UpdateGroundComponent
